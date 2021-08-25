package com.shadow.order.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;


@FeignClient(value = "offer", url = "http://localhost:8080/oferta")
public interface OfferServiceProxy extends OfferService{

    @Override
    @GetMapping
    List<Object> getOffer();

    @Override
    @GetMapping("{id}")
    List<Object> getOfferById(Long id);

    @Override
    @GetMapping("{desconto}")
    List<Object> getOfferByDesconto(BigDecimal desconto);

    @Override
    @GetMapping("{product}")
    List<Object> getProductByProduct(BigDecimal product);
}
