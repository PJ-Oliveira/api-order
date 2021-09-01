package com.shadow.order.domain.models;


import java.math.BigDecimal;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Offer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull

    private Long idOffer;
    @NotNull
    private BigDecimal desconto;
    @NotNull
    private Date inicio;
    @NotNull
    private Date fim;
    private String descricao;

}