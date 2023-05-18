package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecordAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordAppApplication.class, args);
		
		//Records service client
		recordClient.sendRequest("get", 1);
		recordClient.sendRequest("getAll");
		Records data = new Records(5, "Abhijit", "Korkonda", "Madinaguda, Hyderabad");
		recordClient.sendRequest("post", data);
		
		//Calculator service client
		CalculatorClient.sendResponse(5, 2, "add");
		CalculatorClient.sendResponse(5, 2, "sub");
		CalculatorClient.sendResponse(5, 2, "mul");
		CalculatorClient.sendResponse(5, 2, "div");
	}
}
