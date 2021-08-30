package com.shadow.order.domain.dto.dtoresponse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.shadow.order.client.OfferClient;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PedidoDtoResponse {


    private Date date;
    private BigDecimal total;
    private Long idOffer;
    private Long idProduct;
    private Long idPedido;
}
