package com.shadow.order.domain.dto.dtorequest;

import com.shadow.order.domain.Pedido;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
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
