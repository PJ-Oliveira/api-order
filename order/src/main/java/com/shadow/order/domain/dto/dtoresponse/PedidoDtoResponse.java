package com.shadow.order.domain.dto.dtoresponse;

import java.math.BigDecimal;
import java.util.List;

import com.shadow.order.domain.models.Item;
<<<<<<< HEAD

import io.swagger.annotations.ApiModelProperty;
=======
>>>>>>> 88f3b1c (Atualizações de Exceções)
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PedidoDtoResponse {

<<<<<<< HEAD

	@ApiModelProperty(value = "Retorna id do pedido cadastrado", example="1")
=======
>>>>>>> 88f3b1c (Atualizações de Exceções)
    private Long idPedido;
	
	@ApiModelProperty(value = "Retorna lista de Itens referente ao pedido cadastrado")
    private List<ItemDtoResponse> item;
	
	@ApiModelProperty(value = "Retorna o valor total do pedido", example = "50.99")
    private BigDecimal totalPedido;




}
