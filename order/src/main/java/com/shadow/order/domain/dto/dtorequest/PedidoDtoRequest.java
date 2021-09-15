package com.shadow.order.domain.dto.dtorequest;

import java.util.List;

import javax.validation.constraints.NotEmpty;

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
	private List<ItemDtoRequest> item;
	
	
}
