package com.shadow.order.domain.dto.dtorequest;

import com.shadow.order.client.OfferClient;
import lombok.*;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDtoRequest {

    private Date date;
    private BigDecimal total;
    private Long idOffer;
    private Long idProduct;




}
