package com.shadow.order.domain.dto.dtorequest;

import java.math.BigDecimal;
import java.util.List;

import com.shadow.order.domain.models.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDtoRequest {

	private List<Item> item;
    private BigDecimal totalPedido;
}
