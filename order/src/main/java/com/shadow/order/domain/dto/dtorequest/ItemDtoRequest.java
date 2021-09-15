package com.shadow.order.domain.dto.dtorequest;


import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDtoRequest {

    private Long idOffer;
    private BigDecimal desconto;
    private Long idProduct;
    @ApiModelProperty(value="Nome do produto a ser adicionado", example="Doril 10mg - 50 comprimidos", required=true)
    @NotEmpty(message = "${field.item.nomeProduct.not.empty}")
    private String nomeProduct;

    @ApiModelProperty(value="Preco unitário do produto", example="20.00", required=true)
    @NotNull(message = "${field.item.precoProduct.not.null}")
    private BigDecimal precoProduct;






}
