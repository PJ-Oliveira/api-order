package com.shadow.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "product", url = "http://localhost:9000/products")
public interface ProductClient {

    @GetMapping
    List<Object> getProduct();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = "application/json")
    Object getProductById(@PathVariable("id") Long id);
}
