
package com.shadow.order.domain.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    
    private Long idOffer;
   
    private BigDecimal desconto;
   
    private Long idProduct;
    
    private String nomeProduct;
    
    private BigDecimal precoProduct;
    
    private BigDecimal valorTotalItem;
    
    
    
}