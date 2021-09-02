package com.shadow.order.domain.dto.dtorequest;


import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OfferDtoRequest {

    private Long idOffer;
    private BigDecimal desconto;

}
