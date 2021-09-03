package com.shadow.order.domain.dto.dtoresponse;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDtoResponse {

    private Long idItem;
    private Long idOffer;
    private BigDecimal desconto;
    private Long idProduct;
    private String nome;
    private BigDecimal totalItens;
    private BigDecimal preco;
}
