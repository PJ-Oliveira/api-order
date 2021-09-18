package com.shadow.order.domain.models;


import java.math.BigDecimal;
<<<<<<< HEAD

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
>>>>>>> 88f3b1c (Atualizações de Exceções)



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {


    
    private Long idOffer;
    private BigDecimal desconto;
<<<<<<< HEAD
 

=======
>>>>>>> 88f3b1c (Atualizações de Exceções)

}