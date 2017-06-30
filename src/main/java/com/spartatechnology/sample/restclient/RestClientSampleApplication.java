package com.spartatechnology.sample.restclient;

import java.util.Scanner;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spartatechnology.sample.restclient.domain.Location;
import com.spartatechnology.sample.restclient.service.LocationFinder;

/**
 * Main init-class for Spring Boot.
 * 
 * @author Daniel Conde Diehl - Sparta Technology
 *
 * History:
 *  Jun 30, 2017 - Daniel Conde Diehl
 */
@SpringBootApplication
public class RestClientSampleApplication implements CommandLineRunner {

	@Autowired
	private LocationFinder locationFinder;
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		try (final Scanner scanner = new Scanner(System. in)) { 
			System.out.println("Please type Zipcode (If running on IDE. Click on Console and then type): ");
			final String input = scanner. nextLine();
			final Location location = locationFinder.getLocation(input);
			System.out.println(ToStringBuilder.reflectionToString(location, ToStringStyle.MULTI_LINE_STYLE));
		}
	}
	
	/**
	 * Main method to start app.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestClientSampleApplication.class, args);
	}
}
