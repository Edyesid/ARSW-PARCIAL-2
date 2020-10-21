package edu.eci.openweather.controllers;

import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.openweather.services.OpenWeatherAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * controller de las peticiones del clima
 */
@Controller
@RequestMapping(value = "/clima")
public class OpenWeatherController {

    @Autowired
	OpenWeatherAppService crs;

	/**
	 * realiza la peticion del clima de la ciudad ingresada
	 * @param city nombre de la ciudad
	 * @return clima de la ciudad
	 */
	@GetMapping(value = "/{city}")
    public ResponseEntity<?> getClimaCity(@PathVariable("city") String city) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("Content-Type", "application/json");
    	try {
    		String data = crs.getclima(city);
			return new ResponseEntity<>(data,headers,HttpStatus.ACCEPTED);
    		
    	} catch (Exception e) {
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
    	}
    }
}
