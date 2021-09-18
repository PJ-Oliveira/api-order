package com.shadow.order.domain.dto.dtoresponse;


import lombok.*;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OfferDtoResponse {


    private Long idOffer;
    private BigDecimal desconto;


}
