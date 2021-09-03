
package com.shadow.order.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.math.BigDecimal;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long idItem;
    @Column(name = "OFFER_ID")
    private Long idOffer;
    /*@Future
    @Column(name = "OFFER_FIM")
    private Date fim;*/
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