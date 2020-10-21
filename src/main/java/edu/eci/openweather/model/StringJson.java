package edu.eci.openweather.model;

/**
 * String json con tiempo
 */
public class StringJson {
	private long time;
	private String stringjson;

	/**
	 * constructor StringJson
	 * @param time tiempo en el que se realizo la peticion
	 * @param stringjson string del json de la peticion
	 */
	public StringJson(long time, String stringjson) {
		this.stringjson = stringjson;
		this.time = time;
	}

	/**
	 * retorna el tiempo en que se realizo la peticion
	 * @return tiempo
	 */
	public long getTime() {
		return time;
	}

	/**
	 * retorna el string del json de la peticion
	 * @return string del json
	 */
	public String getStringJson() {
		return stringjson;
	}
}
