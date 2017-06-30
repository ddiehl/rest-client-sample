/**
 * Sparta Software Co.
 * 2017
 */
package com.spartatechnology.sample.restclient.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Domain Class for AlternateName used in the Location.
 * 
 * @author Daniel Conde Diehl - Sparta Technology
 *
 * History:
 *  Jun 30, 2017 - Daniel Conde Diehl
 */

public class AlternateName {

	private String city;
	private String state;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
