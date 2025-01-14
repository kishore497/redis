package com.ajtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ajtech.repo.jpa")  // Specify the correct package
@EnableRedisRepositories(basePackages = "com.ajtech.repo.redis")  // Specify Redis repositories
@EnableCaching
public class SpringRedisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}
}
