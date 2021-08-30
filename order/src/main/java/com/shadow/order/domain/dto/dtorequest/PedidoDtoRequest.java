package com.shadow.order.domain.dto.dtorequest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
