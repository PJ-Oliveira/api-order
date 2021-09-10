package com.shadow.order.domain.dto.dtorequest;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDtoRequest {

    private Long idOffer;
    private BigDecimal desconto;
    private Long idProduct;
    private String nomeProduct;
    private BigDecimal totalItens;
    private BigDecimal precoProduct;

}
