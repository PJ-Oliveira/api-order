package com.shadow.order.domain.dto.dtorequest;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDtoRequest {

    private Date date;
    private BigDecimal total;
    @NotNull
    private List<Long> idOffer;
    private List<Long> idProduct;

    //todo:Precisa ser List, pois um Pedido pode ter tanto múltiplos produtos quanto múltiplas promoções ligadas a seus respectivos produtos

}
