package com.bit.CVQS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CvqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvqsApplication.class, args);
	}


	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
}
