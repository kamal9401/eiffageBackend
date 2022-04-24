package com.eiffage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EiffageAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(EiffageAppApplication.class, args);
		DataInitilizer data = new DataInitilizer(ctx);
		data.fillDataBase();
	}

}
