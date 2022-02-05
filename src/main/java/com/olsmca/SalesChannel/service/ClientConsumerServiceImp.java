package com.olsmca.SalesChannel.service;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientConsumerServiceImp implements ClientConsumerService{
  private static final String BASE_URL_INFO_BASIC = "http://localhost:8080/users";
  private static final String BASE_URL_CRIMINAL_RECORD = "http://localhost:8080/users";
  
  private final RestTemplate restTemplate;
  private static final ObjectMapper mapper = new ObjectMapper();

  public ClientConsumerServiceImp() {
    this.restTemplate = new RestTemplate();
  }

  @Override
  public Object getInfoBasic(int id) {
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(BASE_URL_INFO_BASIC, id, String.class);
    return responseEntity.getBody();
  }

  @Override
  public Object getCriminalRecord(int id) {
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(BASE_URL_CRIMINAL_RECORD, id, String.class);
    return responseEntity.getBody();
  }
}
