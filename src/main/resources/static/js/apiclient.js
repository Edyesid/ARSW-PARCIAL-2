var apiclient = (function(){
    return {
        getClima : function(city, callback) {
            var promise = $.getJSON({
                url: "/clima" + "/" + city
            });
            promise
                .then(response => callback(response))
                .catch(err => console.log(err));
        },
        getUbicaciones : function(city, callback) {
            var promise = $.getJSON({
                url: "/clima" + "/" + city
            });
            promise
                .then(response => callback(response))
                .catch(err => console.log(err));
        }
    }
})();