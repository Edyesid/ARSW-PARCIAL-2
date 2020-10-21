package edu.eci.openweather.http;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kong.unirest.Unirest;
import kong.unirest.UnirestException;


@Component
public class HttpConnectApi {

	public String getClima(String city) {
		System.out.println(
				"------------------------------======================getClima==============================--------------------------");
		String json = null;
		try {
			HttpResponse<String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=a8ea6e908a7be4c2c1f88bd82c198b13")
					.header("accept", "application/json")
					.asString();
			json = response.getBody();
			System.out.println(response);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
