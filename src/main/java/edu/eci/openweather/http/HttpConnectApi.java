package edu.eci.openweather.http;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kong.unirest.Unirest;
import kong.unirest.UnirestException;


@Component
public class HttpConnectApi {
	public String getAllCountries() {
		String json = null;
		try {
			kong.unirest.HttpResponse<String> response = Unirest.get("https://rapidapi.p.rapidapi.com/v1/stats")
					.header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
					.header("x-rapidapi-key", "bf3a51a2fbmsha9cb1d8479b1204p1ed44ejsn98781f64912c").asString();
			json = response.getBody();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String getCountry(String country) {
		System.out.println(
				"------------------------------======================getCountry==============================--------------------------");
		String json = null;
		try {
			kong.unirest.HttpResponse<String> response = Unirest
					.get("https://rapidapi.p.rapidapi.com/v1/stats?country=" + country)

					.header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
					.header("x-rapidapi-key", "bf3a51a2fbmsha9cb1d8479b1204p1ed44ejsn98781f64912c").asString();
			json = response.getBody();
			System.out.println(response);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
	
	public String getUbication(String country) {
		System.out.println(
				"------------------------------======================getCountry==============================--------------------------");
		String json = null;
		try {
			kong.unirest.HttpResponse<String> response = Unirest.get("https://rapidapi.p.rapidapi.com/name/" + country)
					.header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
					.header("x-rapidapi-key", "bf3a51a2fbmsha9cb1d8479b1204p1ed44ejsn98781f64912c")
					.asString();
			json = response.getBody();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
	
}
