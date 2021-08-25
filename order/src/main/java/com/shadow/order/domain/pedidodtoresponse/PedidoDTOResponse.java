package com.shadow.order.domain.pedidodtoresponse;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PedidoDTOResponse {

    @OneToMany
    @Column(name = "desconto_Offer")
    private List<BigDecimal> desconto;
    @OneToMany
    @Column(name = "valor_Product")
    private List<BigDecimal> product;
    private Date date;
    private String descricao;
    private BigDecimal total;
}
