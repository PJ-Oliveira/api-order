package com.shadow.order.configuration;

import com.shadow.order.domain.models.Offer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;


@FeignClient(value = "${feign.offer.name}", url = "${feign.offer.url}")
public interface OfferClientConfig {

    @RequestMapping(method = RequestMethod.GET, value = "exist/{id}", consumes ="application/json")
    Optional<Offer> verifyIfOfferExist(@Valid @PathVariable("id")Long id);

}