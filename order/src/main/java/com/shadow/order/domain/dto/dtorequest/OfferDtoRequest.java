package com.shadow.order.domain.dto.dtorequest;


import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OfferDtoRequest {

    private Long idOffer;
    private BigDecimal desconto;
    /*@Future
    private LocalDate fim;*/

}
