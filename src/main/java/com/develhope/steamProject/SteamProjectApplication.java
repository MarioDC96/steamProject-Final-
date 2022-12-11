package com.develhope.steamProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.develhope.steamProject"})
public class SteamProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteamProjectApplication.class, args);
	}

}
