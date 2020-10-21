package edu.eci.openweather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.openweather.cache.CacheConfiguration;
import edu.eci.openweather.http.HttpConnectApi;

/**
 * servicio del clima
 */
@Service
public class OpenWeatherAppService {
	@Autowired
	HttpConnectApi hca;
	
	@Autowired
	CacheConfiguration cc;

	/**
	 * realiza la peticion si no hay cache guardada, si hay cache la pide en memoria
	 * @param city nombre de la ciudad
	 * @return string json de la peticion
	 */
	public String getclima(String city) {
		System.out.println("entro");
		String json;
		if(cc.isCache(city)) {
			json = cc.getCache(city);
			System.out.println("-------uso--cache------");
		} else {
			json = hca.getClima(city);
			cc.saveCache(city, json);
			System.out.println("-------guardo-cache-------");
		}
		return json;
	}
}
