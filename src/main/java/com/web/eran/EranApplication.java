package com.web.eran;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.web.eran.dao")
public class EranApplication {

	public static void main(String[] args) {
		SpringApplication.run(EranApplication.class, args);
	}
}
