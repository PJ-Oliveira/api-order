package com.shadow.order.domain.dto.dtorequest;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.shadow.order.domain.models.Item;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDtoRequest {

	@ApiModelProperty(value = "Informar item a ser adicionado ao produto", required = true)
	@NotEmpty(message = "${field.pedido.item.not.empty}")
	private List<Item> item;
	
	@ApiModelProperty(value = "Valor total do pedido com a adição dos items", example = "50.99", required = true)
	@NotNull(message = "${field.pedido.totalPedido.not.null}")
    private BigDecimal totalPedido;
}
