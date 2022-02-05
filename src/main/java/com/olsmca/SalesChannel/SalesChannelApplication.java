package com.olsmca.SalesChannel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SalesChannelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesChannelApplication.class, args);
	}

	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

	@Bean
    public WebClient webClient(){
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector()).build();
    }

}
