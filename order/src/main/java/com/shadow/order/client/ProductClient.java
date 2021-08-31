package com.shadow.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${feign.product.name}", url = "${feign.product.url}")
public interface ProductClient {

   
    @RequestMapping(method = RequestMethod.GET, value = "product/{id}", consumes = "application/json")
    Long getByIdProduct(@PathVariable("id") Long id);
}
