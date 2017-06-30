/**
 * Sparta Software Co.
 * 2017
 */
package com.spartatechnology.sample.restclient.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bean representation of the response JSON for the request.
 * 
 * @author Daniel Conde Diehl - Sparta Technology
 *
 * History:
 *  Jun 30, 2017 - Daniel Conde Diehl
 */

public class Location {
	@JsonProperty("zip_code")
	private Long zipCode;
	
	@JsonProperty("lat")
	private Double latitude;
	
	@JsonProperty("lng")
	private Double longitude;
	
	private String city;
	private String state;
	private Timezone timezone;
	
	@JsonProperty("acceptable_city_names")
	private AlternateName[] acceptableCityNames;
	
	
	/**
	 * @return the zipCode
	 */
	public Long getZipCode() {
		return zipCode;
	}



	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}



	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}



	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}



	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}



	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}



	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}



	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}



	/**
	 * @return the timezone
	 */
	public Timezone getTimezone() {
		return timezone;
	}



	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}



	/**
	 * @return the acceptableCityNames
	 */
	public AlternateName[] getAcceptableCityNames() {
		return acceptableCityNames;
	}



	/**
	 * @param acceptableCityNames the acceptableCityNames to set
	 */
	public void setAcceptableCityNames(AlternateName[] acceptableCityNames) {
		this.acceptableCityNames = acceptableCityNames;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
