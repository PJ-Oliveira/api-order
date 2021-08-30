package com.shadow.order.service;


import java.math.BigDecimal;
import java.util.List;

import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;

public interface ClienteService {
    
    
    public List<Object> getOffer();

    public List<Object> getOfferById(Long id);

    public List<Object> getOfferByDesconto(BigDecimal desconto);

    public List<Object> getProductByProduct(BigDecimal product);
    
    PedidoDtoResponse getById(long id);

}
