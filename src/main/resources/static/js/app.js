var app = (function(){
    var map;
    var coordenadas;

    var initMap = function() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });
        plotMarkers(coordenadas);
    }

    function plotMarkers(m) {
        markers = [];
        bounds = new google.maps.LatLngBounds();

        m.forEach(function (marker) {
            var position = new google.maps.LatLng(marker.lat, marker.lng);
            console.log("-------------------------------");
            console.log(position);
            markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
            );

            bounds.extend(position);
        });

        map.fitBounds(bounds);
    }

    var buildTable = function(json) {
        console.log(json.main)
        let table = $("#id_table > tbody");
        table.empty();
        climaByCity = {
            temp:json.main.temp,
            feels_like:json.main.feels_like,
            temp_min:json.main.temp_min,
            temp_max:json.main.temp_max,
            pressure:json.main.pressure,
            humidity:json.main.humidity,
        }
        console.log(climaByCity);
        table.append(
            `<tr> 
                <th>${json.main.temp}</th>
                <th>${json.main.feels_like}</th>
                <th>${json.main.temp_min}</th>
                <th>${json.main.temp_max}</th>
                <th>${json.main.pressure}</th>
                <th>${json.main.humidity}</th>
            </tr>`
        );
        ubicaciones(json);
    }

    var ubicaciones = function(propiedades) {

        var json = propiedades;
        coordenadas = [];			
        var coordenadasJson = {lat:json.coord.lat, lng:json.coord.lon};
        coordenadas.push(coordenadasJson);
        console.log(coordenadas);
        initMap();

    }

    return {
        getClima: function(name) {
            apiclient.getClima(name,buildTable);
        }
    }
})();