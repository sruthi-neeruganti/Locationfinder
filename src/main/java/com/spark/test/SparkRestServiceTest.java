package com.spark.test;

import static spark.Spark.*;
import com.google.gson.Gson;

import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;

public class SparkRestServiceTest {

	public static void main(String[] args) {
		IPGeolocationAPI api = new IPGeolocationAPI("fca667c3cab84187b60b5b71d6e0bef0");

		get("/hello", (req, res) -> "Hello World");
		//Rest api to get location data based on ip address
		get("/geolocate/:ipaddress", (req, res) -> {
			res.type("application/json");

			GeolocationParams geoParams = new GeolocationParams();

			geoParams.setIPAddress(req.params(":ipaddress"));
			geoParams.setFields("geo,time_zone,currency");

			Geolocation geolocation = api.getGeolocation(geoParams);
			GeoLocationData data = new GeoLocationData();

			if (geolocation.getStatus() == 200) {
				data.setCountryName(geolocation.getCountryName());
				data.setCurrencyName(geolocation.getCurrency().getName());
				data.setStatusCode(geolocation.getStatus());
				data.setMessage(geolocation.getMessage());

			} else {
				data.setStatusCode(geolocation.getStatus());
				data.setMessage(geolocation.getMessage());
				System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
			}
			return new Gson().toJson(data);
		});
	}

}
