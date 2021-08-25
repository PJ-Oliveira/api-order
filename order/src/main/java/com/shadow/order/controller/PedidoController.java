package com.shadow.order.controller;

import com.shadow.order.service.OfferServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    private final OfferServiceProxy offerServiceProxy;

    @GetMapping
    public List<Object> getOffer(){
        return offerServiceProxy.getOffer();
    }





}
