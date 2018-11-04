package com.fsu.base.federationofsport;

import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@ComponentScan
public class FederationOfSportApplication implements CommandLineRunner {

    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(FederationOfSportApplication.class, args);
    }

    @Override
    public void run(String... arg) throws Exception {
//        storageService.deleteAll();
        storageService.init();
    }
}
