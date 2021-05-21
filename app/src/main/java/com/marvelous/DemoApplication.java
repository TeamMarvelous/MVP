package com.marvelous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.marvelous.*")
@EntityScan("com.marvelous.*")
@EnableJpaRepositories("com.marvelous.*")
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Hello");
        SpringApplication.run(DemoApplication.class);
    }

}
