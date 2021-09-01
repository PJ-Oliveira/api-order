
package com.shadow.order.domain.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idItem;
    @OneToOne
    @NotNull
    private Offer offer;
    @OneToOne
    private Product product;
    private BigDecimal total;





}