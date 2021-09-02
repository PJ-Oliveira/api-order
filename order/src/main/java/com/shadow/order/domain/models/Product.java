package com.shadow.order.domain.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

<<<<<<< HEAD
	
    private Long id;
=======
    @Id
    private Long idProduct;
>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb
    private String nome;
    private BigDecimal preco;

}