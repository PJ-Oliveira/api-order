
package com.shadow.order.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class Item {



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