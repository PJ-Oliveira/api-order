package com.shadow.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;


@FeignClient(value = "offer", url = "http://localhost:8080/oferta")
public interface OfferClient {

    @GetMapping
    List<Object> getOffer();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = "application/json")
    Object getOfferById(@PathVariable("id") Long id);

}