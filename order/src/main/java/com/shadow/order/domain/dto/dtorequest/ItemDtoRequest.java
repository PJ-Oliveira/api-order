package com.shadow.order.domain.dto.dtorequest;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDtoRequest {

	@ApiModelProperty(value = "Id da oferta referente ao produto",example =  "1",required = true)
	@NotNull(message = "${field.item.idOffer.not.null}")
    private Long idOffer;


	
	@ApiModelProperty(value = "Valor do desconto referente a oferta informada", example = "2.99", required = true)
	@NotNull(message = "${field.item.desconto.not.empty}")

    private BigDecimal desconto;
	
	@ApiModelProperty(value="Id de um produto a ser adicionado", example="1", required=true)
	@NotNull(message="${field.item.idProduct.not.null}")
    private Long idProduct;
	
	@ApiModelProperty(value="Nome do produto a ser adicionado", example="Doril 10mg - 50 comprimidos", required=true)
	@NotEmpty(message = "${field.item.nomeProduct.not.empty}")
    private String nomeProduct;
	
	@ApiModelProperty(value="Preco unitário do produto", example="20.00", required=true)
	@NotNull(message = "${field.item.precoProduct.not.null}")
	private BigDecimal precoProduct;
	

    


}
