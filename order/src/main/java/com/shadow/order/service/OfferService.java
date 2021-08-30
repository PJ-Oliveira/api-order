package com.shadow.order.service;

import com.shadow.order.client.OfferClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    private OfferClient offerClient;




    //service que chama o client
    //service que chama o repository
    //só quando necessário, of course
    //1. cria pedido. antes de salvar, chamar http,

}
