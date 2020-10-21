package edu.eci.openweather.cache;


import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import edu.eci.openweather.model.StringJson;
/**
 * El chache de una consulta del clima sera un hashmap
 */
@Component
public class CacheConfiguration {
	
	private ConcurrentHashMap<String, StringJson> cache = new ConcurrentHashMap<>();

	/**
	 * verfica si no han pasado 5 minutos desde la ultma peticion
	 * @param city nombre de la ciudad
	 * @return boolean de acuerdo a la condicion
	 */
	public synchronized boolean isCache(String city) {
		boolean hayCache = false;
		if (cache.get(city) != null && System.currentTimeMillis() - cache.get(city).getTime() <= 900000) {
			hayCache = true;
		}	
		return hayCache;
	}

	/**
	 * Si no har registro de cache este metodo crea una nueva
	 * @param name nombre de la ciudad
	 * @param stringjson json de la peticion
	 */
	public void saveCache(String name, String stringjson) {
		StringJson json = new StringJson(System.currentTimeMillis(), stringjson);
		cache.put(name, json);
		System.out.println("cache");
	}

	/**
	 * retorna el cache guardado
	 * @param name nombre de la ciudad
	 * @return peticion guardada en el hashmap cache
	 */
	public String getCache(String name) {
		return cache.get(name).getStringJson();
	}
}