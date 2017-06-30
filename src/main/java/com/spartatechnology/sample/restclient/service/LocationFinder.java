/**
 * Sparta Software Co.
 * 2017
 */
package com.spartatechnology.sample.restclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spartatechnology.sample.restclient.domain.Location;

/**
 * Service for accessing ZipCode Rest WS.
 * 
 * @author Daniel Conde Diehl - Sparta Technology
 *
 * History:
 *  Jun 29, 2017 - Daniel Conde Diehl
 */
@Service
public class LocationFinder {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${com.sparta.sample.api-key}")
	private String apiKey;
	
	/**
	 * Retrieves location based on Zipcode.
	 * 
	 * @param zipcode zipcode to find location
	 * @return Location found
	 * @throws Exception In case cannot find location
	 */
	public Location getLocation(String zipcode) throws Exception {
		final String url = 
				"https://www.zipcodeapi.com/rest/{apiKey}/info.json/{zipcode}/degrees";
		final ResponseEntity<Location> resp = restTemplate.getForEntity(url, Location.class, 
										apiKey, zipcode);
		
		if (resp.getStatusCode() != HttpStatus.OK) {
			throw new Exception("Error retrieving result. HTTP_STATUS=" + resp.getStatusCodeValue());
		}
		
		return resp.getBody();
	}
}
