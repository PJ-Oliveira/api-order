package com.shadow.order.service;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;



@FeignClient(value = "offer", url = "http://localhost:8080/oferta")
public interface ClientServiceProxy extends ClienteService {


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

    @Override
    @GetMapping("{id}")
    PedidoDtoResponse getById(long id);


}
