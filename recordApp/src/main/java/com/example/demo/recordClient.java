package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class recordClient {
	public static void sendRequest(String method, int index) {
		RestTemplate restTemplet = new RestTemplate();
		if(method.equals("get")) {
			String result = restTemplet.getForObject("http://localhost:8080/registry/records/"+index, String.class);
			System.out.println("Record requested: "+result);
		}
	}

	public static void sendRequest(String method) {
		RestTemplate restTemplet = new RestTemplate();
		if(method.equals("getAll")) {
			String result = restTemplet.getForObject("http://localhost:8080/registry/records", String.class);
			System.out.println("Record requested: "+result);
		}
	}

	public static void sendRequest(String method, Records data) {
		RestTemplate restTemplet = new RestTemplate();
		if(method.equals("post")) {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Records> request = new HttpEntity<Records>(data, header);
			ResponseEntity<String> response = restTemplet.postForEntity("http://localhost:8080/registry/records/add", request, String.class);
			String result = response.getBody();
			System.out.println("Record requested: "+result);
		}
	}
}
