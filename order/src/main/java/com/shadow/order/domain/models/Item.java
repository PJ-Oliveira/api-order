
package com.shadow.order.domain.models;

import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Item {

    
    private Long id;
    private Long id_product;
    private String product_name;
    //private BigDecimal precoProduct;
    private int quantidade;
    //private BigDecimal total;
   


=======
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_item")
public class Item {

<<<<<<< HEAD
>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb


=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private Long idItem;
>>>>>>> 61ee44e00609cad064417102389530ba6c62d4dc
    @Column(name = "OFFER_ID")
    private Long idOffer;
    @Column(name = "DESCONTO")
    private BigDecimal desconto;
    @Column(name = "PRODUCT_ID")
    private Long idProduct;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "totalItens")
    private BigDecimal totalItens;
    @Column(name = "PRECO")
    private BigDecimal preco;

}