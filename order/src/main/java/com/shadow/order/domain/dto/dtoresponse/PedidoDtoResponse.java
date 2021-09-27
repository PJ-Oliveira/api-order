package com.shadow.order.domain.dto.dtoresponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@ApiModelProperty(value = "Retorna a data e hora da criação do pedido", example = "21/09/2021 14:25:00")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataPedido;
	
	@ApiModelProperty(value = "Retorna o valor total do pedido", example = "50.99")
    private BigDecimal totalPedido;




}
