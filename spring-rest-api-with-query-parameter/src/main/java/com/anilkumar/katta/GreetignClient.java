package com.anilkumar.katta;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GreetignClient {

	public static void main(String[] args) {
		String url = "http://localhost:8080/greeting";
		RestTemplate rt = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("name", "AK185292");

		HttpEntity<?> entity = new HttpEntity<>(headers);
		System.out.println(builder.toUriString());
		HttpEntity<String> response = rt.exchange(
		        builder.toUriString(), 
		        HttpMethod.POST, 
		        entity, 
		        String.class);
	
		System.out.println(response.getBody());
	}
}
