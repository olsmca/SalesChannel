package com.olsmca.SalesChannel.controller;

import java.net.URISyntaxException;
import java.time.Duration;
import java.time.Instant;

import com.olsmca.SalesChannel.model.Client;
import com.olsmca.SalesChannel.service.ClientConsumerService;
import com.olsmca.SalesChannel.service.SalesChannelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SalesChannelController {

    @Autowired
    ClientConsumerService clientConsumerService;

    @Autowired
    SalesChannelService salesChannelService;

    @PostMapping(value = "potencialclient")
    public ResponseEntity<Void> customerPotencial(@RequestBody final Client client) throws URISyntaxException{
      Instant inst1 = Instant.now();  
      System.out.println("inicio: "+inst1);
      System.out.println("ID Client: "+client.getDni());
        
      System.out.println(clientConsumerService.getInfoBasic(client));
      System.out.println(clientConsumerService.getCriminalRecord(client));
      Instant inst2 = Instant.now();
      System.out.println("Elapsed Time: "+ Duration.between(inst1, inst2).toString());

        //return new ResponseEntity<>(true?HttpStatus.OK:HttpStatus.FORBIDDEN);
        
      return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value = "prospect")
    public ResponseEntity<Void> potencialclient(@RequestBody final Client client) throws URISyntaxException{
      
      salesChannelService.verifyProspect(client);

      return new ResponseEntity<>(HttpStatus.OK);
    }
}
