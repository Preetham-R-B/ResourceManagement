package com.Project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration
//@EntityScan(basePackages = "com.Prpject.demo")
public class ProjectV1Application {

//	@Bean(name = "entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		return sessionFactory;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectV1Application.class, args);
	}

}
