package com.spark.test;

public class GeoLocationData {
	
	
	private String countryName;
	private String currencyName;
	private int statusCode;
	private String message;
	public GeoLocationData() {
		
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GeoLocationData(String countryName, String currencyName, int statusCode, String message) {
		super();
		this.countryName = countryName;
		this.currencyName = currencyName;
		this.statusCode = statusCode;
		this.message = message;
	}
	
	

}
