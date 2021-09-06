package com.shadow.order.domain.dto.dtorequest;


import lombok.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OfferDtoRequest {

    private Long idOffer;
    private BigDecimal desconto;

}
