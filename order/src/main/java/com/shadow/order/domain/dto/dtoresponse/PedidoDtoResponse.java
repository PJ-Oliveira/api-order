package com.shadow.order.domain.dto.dtoresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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
