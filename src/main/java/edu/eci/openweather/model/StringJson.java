package edu.eci.openweather.model;

public class StringJson {
	private long time;
	private String stringjson;
	public StringJson(long time, String stringjson) {
		this.stringjson = stringjson;
		this.time = time;
	}
	public long getTime() {
		return time;
	}
	public String getStringJson() {
		return stringjson;
	}
}
