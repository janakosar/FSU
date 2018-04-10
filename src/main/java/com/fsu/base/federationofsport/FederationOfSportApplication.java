package com.fsu.base.federationofsport;

import com.fsu.base.federationofsport.storage.StorageProperties;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties(StorageProperties.class)
public class FederationOfSportApplication {

	public static void main(String[] args) {
		SpringApplication.run(FederationOfSportApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
