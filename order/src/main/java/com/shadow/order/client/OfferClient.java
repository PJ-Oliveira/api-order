package com.shadow.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Optional;


@FeignClient(value = "offer", url = "http://localhost:8080/oferta")
public interface OfferClient {

    @GetMapping
    List<Object> getOffer();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = "application/json")
    Object getOfferById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value ="desconto/{id}", consumes = "application/json")
    Object getDescontoOffer(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value ="fim/{id}", consumes = "application/json")
    Object getDataFim(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value ="existOrNot/{id}", consumes = "application/json")
    Long getIdOffer(@PathVariable("id") Long id);





}