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

    var buildTable = function(virus) {
        console.log(virus.data.covid19Stats);
        let table = $("#id_table > tbody");
        table.empty();
        
        virusByCountry = virus.data.covid19Stats.map(({province,deaths,confirmed,recovered}) =>({
            province: province,
            deaths:deaths,
            confirmed:confirmed,
            recovered:recovered,
        }))
        virusByCountry.forEach(({province,deaths,confirmed,recovered}) => {
            table.append(
                `<tr> 

                      <th>${province}</th>
                      <th>${deaths}</th>
                      <th>${confirmed}</th>
                      <th>${recovered}</th>
                </tr>`
            );
        })
    }

    var ubicaciones = function(propiedades) {
        var json2 = JSON.stringify(propiedades); //posible
        var json = propiedades[0];
        coordenadas = [];			
        var coordenadasJson = {lat:json.latlng[0], lng:json.latlng[1]};
        coordenadas.push(coordenadasJson);
        console.log(coordenadas);
        initMap();
    }

    return {
        getCountry: function(name) {
            apiclient.getCountry(name,buildTable);
        },
        getUbicaciones: function(name) {
            apiclient.getUbicaciones(name,ubicaciones)
            app.getCountry(name);
        }
    }
})();