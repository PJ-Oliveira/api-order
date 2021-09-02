package com.shadow.order.domain.dto.dtoresponse;


import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OfferDtoResponse {


    private Long idOffer;
    private BigDecimal desconto;


}
