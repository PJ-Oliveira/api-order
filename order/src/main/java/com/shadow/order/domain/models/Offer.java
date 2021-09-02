package com.shadow.order.domain.models;


import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD

public class Offer {

  
    private Long idOffer;
    private BigDecimal desconto;
    private Date inicio;
    private Date fim;
    private String descricao;
=======
@Entity
public class Offer {


    @Id
    private Long idOffer;
    private BigDecimal desconto;

>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb

}