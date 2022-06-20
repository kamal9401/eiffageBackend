package com.eiffage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EiffageAppApplication {
	@Autowired
	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(EiffageAppApplication.class, args);
		DataInitilizer data = new DataInitilizer(ctx);
		data.fillDataBase();
	}
}
