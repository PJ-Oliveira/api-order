package com.shadow.order.client;

import com.shadow.order.domain.models.Offer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@FeignClient(value = "${feign.offer.name}", url = "${feign.offer.url}")
public interface OfferClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes ="application/json")
    Offer findOneOffer(@PathVariable("id")@NotNull  @Valid Long id);


}