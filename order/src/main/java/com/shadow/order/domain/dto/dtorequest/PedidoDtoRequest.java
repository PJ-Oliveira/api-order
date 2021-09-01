package com.shadow.order.domain.dto.dtorequest;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


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
