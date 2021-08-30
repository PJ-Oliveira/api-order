package com.shadow.order.domain.dto.dtorequest;

import lombok.*;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDtoRequest {

    private Long id;
    private List<Object> desconto;
    private List<Object> product;
    private Date date;
    private BigDecimal total;





}
