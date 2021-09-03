package com.shadow.order.domain.models;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Future;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer {


    @Id
    private Long idOffer;
    private BigDecimal desconto;
    /*@Future
    private LocalDate fim;*/


}