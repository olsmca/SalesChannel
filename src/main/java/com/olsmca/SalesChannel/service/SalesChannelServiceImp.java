package com.olsmca.SalesChannel.service;

import java.time.Duration;
import java.time.Instant;

import com.olsmca.SalesChannel.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class SalesChannelServiceImp implements SalesChannelService{

    @Autowired
    ClientConsumerService clientConsumerService;  
    
    @Override
    public void verifyProspect(Client client) {
      Instant inst1 = Instant.now();  
      System.out.println("inicio: "+inst1);
      System.out.println("ID Client: "+client.getDni());

      Flux<Client> flux = Flux.merge(clientConsumerService.getInfoClient(client),clientConsumerService.getCriminalInfo(client));
      //clientConsumerService.getInfoClient(client);
      flux.subscribe(System.out::println);

      Instant inst2 = Instant.now();
      System.out.println("Elapsed Time: "+ Duration.between(inst1, inst2).toString());

    }
    
}
