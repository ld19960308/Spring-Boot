package com;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args){
		//SpringApplication app=new SpringApplication();
		//app.setBannerMode(Banner.Mode.OFF);
		//app.run(args);
		SpringApplication.run(Application.class, args);
		System.out.println("have finshed");
	}

}
