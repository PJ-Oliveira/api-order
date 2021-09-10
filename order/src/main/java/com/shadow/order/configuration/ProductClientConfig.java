package com.shadow.order.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.shadow.order.domain.models.Product;

@FeignClient(value = "${feign.product.name}", url = "${feign.product.url}")
public interface ProductClientConfig {
   
    
   @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes ="application/json")
    Product getById(@PathVariable("id") Long id);
    
}
