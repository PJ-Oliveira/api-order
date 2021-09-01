package com.shadow.order.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_Offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOffer;
    private BigDecimal desconto;

}
