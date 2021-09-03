package com.shadow.order.domain.dto.dtorequest;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDtoRequest {

    private Long idOffer;
    private BigDecimal desconto;
    private Long idProduct;
    private String nome;
    private BigDecimal totalItens;
    private BigDecimal preco;

}
