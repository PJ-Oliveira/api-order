package com.shadow.order.domain.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    private Long id;
    private String nome;
    private BigDecimal preco;

}