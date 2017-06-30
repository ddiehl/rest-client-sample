/**
 * Sparta Software Co.
 * 2017
 */
package com.spartatechnology.sample.restclient.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Timezone object used in the Location.
 * 
 * @author Daniel Conde Diehl - Sparta Technology
 *
 * History:
 *  Jun 30, 2017 - Daniel Conde Diehl
 */

public class Timezone {
	private String timezoneIdentifier;
	
	@JsonProperty(value="timezone_abbr")
	private String timezoneAbbreviation;
	
	private String utcOffsetSec;
	private String isDst;
	/**
	 * @return the timezoneIdentifier
	 */
	public String getTimezoneIdentifier() {
		return timezoneIdentifier;
	}
	/**
	 * @param timezoneIdentifier the timezoneIdentifier to set
	 */
	public void setTimezoneIdentifier(String timezoneIdentifier) {
		this.timezoneIdentifier = timezoneIdentifier;
	}
	/**
	 * @return the timezoneAbbreviation
	 */
	public String getTimezoneAbbreviation() {
		return timezoneAbbreviation;
	}
	/**
	 * @param timezoneAbbreviation the timezoneAbbreviation to set
	 */
	public void setTimezoneAbbreviation(String timezoneAbbreviation) {
		this.timezoneAbbreviation = timezoneAbbreviation;
	}
	/**
	 * @return the utcOffsetSec
	 */
	public String getUtcOffsetSec() {
		return utcOffsetSec;
	}
	/**
	 * @param utcOffsetSec the utcOffsetSec to set
	 */
	public void setUtcOffsetSec(String utcOffsetSec) {
		this.utcOffsetSec = utcOffsetSec;
	}
	/**
	 * @return the isDst
	 */
	public String getIsDst() {
		return isDst;
	}
	/**
	 * @param isDst the isDst to set
	 */
	public void setIsDst(String isDst) {
		this.isDst = isDst;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
