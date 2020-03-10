package com.sciencom.springmvcexample.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sciencom.springmvcexample.model.Country;


@Repository
public class CountryRepository {
	private static final Map<String, Country> COUNTRIES = new HashMap<>();
	//Static Initial Block
	static {
		Country id = new Country("id", "Indonesia");
		Country en = new Country("en", "United Kingdom");
		Country us = new Country("us", "United State");
		Country au = new Country("au", "Australia");
		
		COUNTRIES.put(id.getCountryCode(), id );
		COUNTRIES.put(en.getCountryCode(), en );
		COUNTRIES.put(us.getCountryCode(), us );
		COUNTRIES.put(au.getCountryCode(), au );
	}
	
	public List<Country> getAllCountry(){
		List<Country> listcountry = new ArrayList<Country>();
		listcountry.addAll(COUNTRIES.values());
		return listcountry;
	}
}
