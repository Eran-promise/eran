package com.web.eran;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.web.eran.dao")
@EnableCaching
public class EranApplication {

	public static void main(String[] args) {
		SpringApplication.run(EranApplication.class, args);
	}
}
