package com.jsure.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@MapperScan("com.jsure.core.mapper")
public class DataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataApiApplication.class, args);
	}
}
