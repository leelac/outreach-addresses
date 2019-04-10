package com.outreach.feedback.addresses.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.outreach.feedback.addresses.models.City;
import com.outreach.feedback.addresses.models.Country;
import com.outreach.feedback.addresses.rest.Payload;
import com.outreach.feedback.addresses.rest.RestfulResponse;

@Component
@Path("/addresses")
public class AddressesController {

	@GET
	@Path("/countries")
    @Produces("application/json")
    public Response getCountries() {
		
		List<Country> countries = new ArrayList<>();
		Country country = new Country();
		country.setName("India");
		countries.add(country);
		country = new Country();
		country.setName("Australia");
		countries.add(country);
		country = new Country();
		country.setName("Canada");
		countries.add(country);
		country = new Country();
		country.setName("France");
		countries.add(country);
		country = new Country();
		country.setName("United Kingdom");
		countries.add(country);
		country = new Country();
		country.setName("United States");
		countries.add(country);
		
		Payload payload = new Payload();
		payload.put("countries", countries);
				
        return new RestfulResponse().ok(payload);
    }
	
	@GET
	@Path("/cities")
    @Produces("application/json")
    public Response getCities(@QueryParam("country") String country) {
		
		List<City> cities = new ArrayList<>();
		if("india".equalsIgnoreCase(country)){
			City city = new City();
			city.setName("Chennai");		
			cities.add(city);
		}else if("united kingdom".equalsIgnoreCase(country)){
			City city = new City();
			city.setName("London");		
			cities.add(city);
		}
		
		Payload payload = new Payload();
		payload.put("cities", cities);
				
        return new RestfulResponse().ok(payload);
    }
	
	
}
