package com.accenture.photos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@EnableFeignClients
public class PhotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotosApplication.class, args);
	}

}
