package com.olsmca.SalesChannel.controller;

import java.util.Date;

import com.olsmca.SalesChannel.model.Client;
import com.olsmca.SalesChannel.service.ClientConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class ClientController {

    @Autowired
    ClientConsumerService clientConsumerService;

    @PostMapping(
  value = "/cunstumerpotencial", consumes = "application/json", produces = "application/json")
    public void customerPotencial(@RequestBody Client client){
        System.out.println("inicio"+new Date());
        System.out.println(clientConsumerService.getInfoBasic(client.getId()));
        System.out.println(clientConsumerService.getCriminalRecord(client.getId()));
        System.out.println("inicio"+new Date());
    }
    
}
