package com.shadow.order.domain.dto.dtoresponse;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PedidoDtoResponse {



	@ApiModelProperty(value = "Retorna id do pedido cadastrado", example="1")
    private Long idPedido;
	
	@ApiModelProperty(value = "Retorna lista de Itens referente ao pedido cadastrado")
    private List<ItemDtoResponse> item;
	
	@ApiModelProperty(value = "Retorna o valor total do pedido", example = "50.99")
    private BigDecimal totalPedido;




}
