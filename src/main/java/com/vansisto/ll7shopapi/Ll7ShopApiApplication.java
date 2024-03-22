package com.vansisto.ll7shopapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Ll7ShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ll7ShopApiApplication.class, args);
	}
}
