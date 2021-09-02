package com.shadow.order.domain.dto.dtorequest;


import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDtoRequest {

    private Long idProduct;
    private String nome;
    private BigDecimal preco;
}
