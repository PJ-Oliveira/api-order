package com.shadow.order.service;


import com.shadow.order.domain.Pedido;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    
    
    public List<Object> getOffer();

    public List<Object> getOfferById(Long id);

    public List<Object> getOfferByDesconto(BigDecimal desconto);

    public List<Object> getProductByProduct(BigDecimal product);
    
    PedidoDtoResponse getById(long id);

}
