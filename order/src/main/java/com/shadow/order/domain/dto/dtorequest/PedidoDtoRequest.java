package com.shadow.order.domain.dto.dtorequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.shadow.order.domain.models.Item;

import com.shadow.order.domain.models.Pedido;
import com.shadow.order.repository.PedidoRepository;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDtoRequest {

	@ApiModelProperty(value = "Informar item a ser adicionado ao produto", required = true)
    @NotEmpty(message = "${field.pedido.item.not.empty}")
    private List<ItemDtoRequest> item;









}
