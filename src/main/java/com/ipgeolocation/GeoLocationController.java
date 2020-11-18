package com.ipgeolocation;

import static spark.Spark.get;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
//import com.spark.test.GeoLocationData;

import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;

@RestController
@RequestMapping("/geolocate")
public class GeoLocationController {

	/**
	 * 
	 * @param ipaddress
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{ipaddress}")
	//Rest api to get location data based on ip address
	public GeoLocationData read(@PathVariable String ipaddress) {
		IPGeolocationAPI api = new IPGeolocationAPI("fca667c3cab84187b60b5b71d6e0bef0");
		//Adding params 
		GeolocationParams geoParams = new GeolocationParams();
		geoParams.setIPAddress(ipaddress);
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
		return data;
	}

	

}
