package com.shadow.order.configuration;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shadow.order.domain.models.Offer;


@FeignClient(value = "${feign.offer.name}", url = "${feign.offer.url}")
public interface OfferClientConfig {


    @RequestMapping(method = RequestMethod.GET, value = "exist/{id}", consumes ="application/json")
    Optional<Offer> findOneOffer(@PathVariable("id")@Valid Long id);
}