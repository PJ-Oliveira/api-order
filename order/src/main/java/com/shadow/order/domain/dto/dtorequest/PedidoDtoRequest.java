package com.shadow.order.domain.dto.dtorequest;

import com.shadow.order.domain.models.Item;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDtoRequest {


    private List<Item> item;
    private BigDecimal total;

}
