package com.wipro.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner display(Laptop laptop) {
        return args -> {
            System.out.println("Laptop: " + laptop.getName());
            System.out.println("Hard Disk: " + laptop.getHardDisk().getCapacity());
            System.out.println("Battery: " + laptop.getBattery().getCapacity());
        };
    }
}
