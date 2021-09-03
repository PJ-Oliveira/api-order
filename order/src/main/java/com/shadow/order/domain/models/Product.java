package com.shadow.order.domain.models;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {


    @Id
    private Long idProduct;
    private String nome;
    private BigDecimal preco;

}