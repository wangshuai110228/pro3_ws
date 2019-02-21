package com.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@MapperScan("com.ws.mapper")
//@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class ProWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProWsApplication.class, args);
	}

}

