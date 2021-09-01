package com.shadow.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shadow.order.domain.models.Product;

@FeignClient(value = "${feign.product.name}", url = "${feign.product.url}")
public interface ProductClient {
<<<<<<< HEAD
   
 
=======


    
>>>>>>> bbf5179a3b3d444630d0e3d53dc12a9aa56cfe6b
   @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes ="application/json")
    Product getById(@PathVariable("id")Long id);
    
}
