package com.shadow.order.domain.dto.dtoresponse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PedidoDtoResponse {

    @OneToMany
    @Column(name = "desconto_Offer")
    private List<Object> desconto;
    @OneToMany
    @Column(name = "valor_Product")
    private List<Object> product;
    private Date date;
    private BigDecimal total;
}
