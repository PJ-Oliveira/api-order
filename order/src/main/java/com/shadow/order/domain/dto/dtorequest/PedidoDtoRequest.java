package com.shadow.order.domain.dto.dtorequest;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDtoRequest {

    private Date date;
    private BigDecimal total;
    @NonNull
    private Long idOffer;
    @NonNull
    private Long idProduct;




}
