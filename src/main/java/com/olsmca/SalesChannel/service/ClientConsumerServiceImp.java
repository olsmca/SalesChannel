package com.olsmca.SalesChannel.service;

import java.net.URI;
import java.net.URISyntaxException;

import com.olsmca.SalesChannel.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ClientConsumerServiceImp implements ClientConsumerService{
  private static final String BASE_URL_INFO_BASIC = "http://127.0.0.1:8081/nationalregistry/";
  private static final String BASE_URL_CRIMINAL_RECORD = "http://127.0.0.1:8081/criminalrecord/";
  
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private WebClient webClient;

  // @Autowired
  // public ClientConsumerServiceImp(RestTemplateBuilder restTemplateBuilder) {
  //   this.restTemplate = restTemplateBuilder.build();
  // }

  @Override
  public Object getInfoBasic(Client client) throws URISyntaxException {
    URI uri = new URI(BASE_URL_INFO_BASIC);
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, client, String.class);
    System.out.println(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  @Override
  public Object getCriminalRecord(Client client)throws URISyntaxException  {
    URI uri = new URI(BASE_URL_CRIMINAL_RECORD);
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, client, String.class);
    System.out.println(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  @Override
  public Mono<Client> getInfoClient(Client client) {
    
    // WebClient webClient = WebClient.create(BASE_URL_INFO_BASIC);
    // Flux<Client> cl =webClient.get().retrieve().bodyToFlux(Client.class);
    return webClient.get().uri(BASE_URL_INFO_BASIC+client.getDni()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Client.class); 
  }

  @Override
  public Mono<Client> getCriminalInfo(Client client) {
    // WebClient webClient = WebClient.create(BASE_URL_CRIMINAL_RECORD);
    // Flux<Client> cl =webClient.get().retrieve().bodyToFlux(Client.class);
    return webClient.get().uri(BASE_URL_CRIMINAL_RECORD+client.getDni()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Client.class); 
  }
}
