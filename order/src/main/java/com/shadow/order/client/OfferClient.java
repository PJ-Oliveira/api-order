package com.shadow.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "${feign.offer.name}", url = "${feign.offer.url}")
public interface OfferClient {

<<<<<<< HEAD

=======
   
>>>>>>> dev001
    @RequestMapping(method = RequestMethod.GET, value ="existOrNot/{id}", consumes = "application/json")
    Long getIdOffer(@PathVariable("id") Long id);

}