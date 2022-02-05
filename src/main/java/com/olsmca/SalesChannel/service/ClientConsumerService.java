package com.olsmca.SalesChannel.service;

import java.net.URISyntaxException;

import com.olsmca.SalesChannel.model.Client;

import reactor.core.publisher.Mono;

public interface ClientConsumerService {

    public Object getInfoBasic(Client client)throws URISyntaxException ;
    public Object getCriminalRecord(Client client)throws URISyntaxException ;

    public Mono<Client> getInfoClient(Client client);
    public Mono<Client> getCriminalInfo(Client client);
    
}
