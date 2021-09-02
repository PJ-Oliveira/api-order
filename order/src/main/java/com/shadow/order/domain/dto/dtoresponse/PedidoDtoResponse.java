package com.shadow.order.domain.dto.dtoresponse;

import java.math.BigDecimal;
import java.util.List;
import com.shadow.order.domain.models.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PedidoDtoResponse {


    private Long idPedido;
    private List<Item> item;
    private BigDecimal total;




}
