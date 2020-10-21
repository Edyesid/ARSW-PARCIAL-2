package edu.eci.openweather.cache;


import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import edu.eci.openweather.model.StringJson;

@Component
public class CacheConfiguration {
	
	private ConcurrentHashMap<String, StringJson> cache = new ConcurrentHashMap<>();
	
	public synchronized boolean isCache(String city) {
		boolean hayCache = false;
		if (cache.get(city) != null && System.currentTimeMillis() - cache.get(city).getTime() <= 900000) {
			hayCache = true;
		}	
		return hayCache;
	}
	
	public void saveCache(String name, String stringjson) {
		StringJson json = new StringJson(System.currentTimeMillis(), stringjson);
		cache.put(name, json);
		System.out.println("cache");
	}
	
	public String getCache(String name) {
		return cache.get(name).getStringJson();
	}
}