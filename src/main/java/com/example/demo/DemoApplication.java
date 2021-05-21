package com.example.demo;

import com.example.demo.controller.UserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	@Autowired
	UserDataController userDataController;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Scheduled(cron = "0/2 * * * * ?")
	public void print(){
		System.out.println("執行定時任務");
		userDataController.getAll();
	}
}
