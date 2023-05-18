package com.example.demo;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CalculatorClient {
	public static void sendResponse(double x, double y, String operation) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON}));
		if(operation.equals("add")) {
			add(x, y, restTemplate, header);
		}
		if(operation.equals("sub")) {
			sub(x, y, restTemplate, header);
		}
		if(operation.equals("mul")) {
			mul(x, y, restTemplate, header);
		}
		if(operation.equals("div")) {
			div(x, y, restTemplate, header);
		}
	}
	private static void add(double x, double y, RestTemplate restTemplate, HttpHeaders header) {
		URI CALCULATOR = URI.create("http://localhost:8080/calculator/add?x="+x+"&y="+y);
		RequestEntity<String> request = new RequestEntity<>(header, HttpMethod.GET, CALCULATOR); 
		ResponseEntity<Result> response = restTemplate.exchange(request, Result.class);
		HttpStatusCode Status = response.getStatusCode();
		if(Status == HttpStatus.OK) {
			Result sum = response.getBody();
			System.out.println("result:\n"+sum.getX()+"\n"+sum.getY()+"\n"+sum.getOpVal()+"\n"+sum.getResult());
		}
	}
	
	private static void sub(double x, double y, RestTemplate restTemplate, HttpHeaders header) {
		URI CALCULATOR = URI.create("http://localhost:8080/calculator/sub?x="+x+"&y="+y);
		RequestEntity<data> request = new RequestEntity<data>(header, HttpMethod.GET, CALCULATOR);
		ResponseEntity<Result> response = restTemplate.exchange(request, Result.class);
		HttpStatusCode Status = response.getStatusCode();
		if(Status == HttpStatus.OK) {
			Result sum = response.getBody();
			System.out.println("result:\n"+sum.getX()+"\n"+sum.getY()+"\n"+sum.getOpVal()+"\n"+sum.getResult());
		}
	}
	private static void mul(double x, double y, RestTemplate restTemplate, HttpHeaders header) {
		URI CALCULATOR = URI.create("http://localhost:8080/calculator/mul?x="+x+"&y="+y);
		RequestEntity<data> request = new RequestEntity<data>(header, HttpMethod.GET, CALCULATOR);
		ResponseEntity<Result> response = restTemplate.exchange(request, Result.class);
		HttpStatusCode Status = response.getStatusCode();
		if(Status == HttpStatus.OK) {
			Result sum = response.getBody();
			System.out.println("result:\n"+sum.getX()+"\n"+sum.getY()+"\n"+sum.getOpVal()+"\n"+sum.getResult());
		}
	}
	private static void div(double x, double y, RestTemplate restTemplate, HttpHeaders header) {
		URI CALCULATOR = URI.create("http://localhost:8080/calculator/div?x="+x+"&y="+y);
		RequestEntity<data> request = new RequestEntity<data>(header, HttpMethod.GET, CALCULATOR);
		ResponseEntity<Result> response = restTemplate.exchange(request, Result.class);
		HttpStatusCode Status = response.getStatusCode();
		if(Status == HttpStatus.OK) {
			Result sum = response.getBody();
			System.out.println("result:\n"+sum.getX()+"\n"+sum.getY()+"\n"+sum.getOpVal()+"\n"+sum.getResult());
		}
	}
}
