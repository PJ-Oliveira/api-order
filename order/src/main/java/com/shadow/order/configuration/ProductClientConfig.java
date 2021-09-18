package com.shadow.order.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



<<<<<<< HEAD:order/src/main/java/com/shadow/order/configuration/ProductClientConfig.java
import com.shadow.order.domain.models.Product;

@FeignClient(value = "${feign.product.name}", url = "${feign.product.url}")
public interface ProductClientConfig {
   
    
=======
>>>>>>> 88f3b1c (Atualizações de Exceções):order/src/main/java/com/shadow/order/client/ProductClient.java
   @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes ="application/json")
    Product getById(@PathVariable("id") Long id);
    
}
