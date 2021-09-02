
package com.shadow.order.domain.models;

import lombok.AllArgsConstructor;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private Long idItem;
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