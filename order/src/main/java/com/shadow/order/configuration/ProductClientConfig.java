package com.shadow.order.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shadow.order.domain.models.Product;

@FeignClient(value = "${feign.product.name}", url = "${feign.product.url}")
public interface ProductClientConfig {


    @GetMapping(value = "/{id}", consumes ="application/json")
    Product  findById(@PathVariable("id") Long id);

}
