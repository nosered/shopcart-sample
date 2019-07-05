package br.eti.esabreu.shopcartsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShopcartSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopcartSampleApplication.class, args);
	}

}
