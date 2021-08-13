package com.thehecklers.flightgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class FlightgenApplication {

	public static void main(String[] args) {
		Hooks.onErrorDropped(err -> System.out.println("RSocket client disconnected."));
		SpringApplication.run(FlightgenApplication.class, args);
	}

}
