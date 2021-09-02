package com.shadow.order.domain.dto.dtoresponse;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDtoResponse {
    private Long idProduct;
    private String nome;
    private BigDecimal preco;

}
