package com.shadow.order.domain.pedidodtorequest;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PedidoDTORequest {

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
