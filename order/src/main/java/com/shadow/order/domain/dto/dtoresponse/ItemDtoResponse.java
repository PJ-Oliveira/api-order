package com.shadow.order.domain.dto.dtoresponse;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class ItemDtoResponse {

	@ApiModelProperty(value = "Retorna o id de um item adicionado", example = "1")
    private Long idItem;
	
	@ApiModelProperty(value = "Retorna o id de uma oferta cadastrada", example = "1")
    private Long idOffer;
	
	@ApiModelProperty(value = "Retorna o desconto referente a oferta cadastrada", example = "2.99")
    private BigDecimal desconto;
	
	@ApiModelProperty(value = "Retorna o ide de um produto cadastrado", example = "2")
    private Long idProduct;
	
	@ApiModelProperty(value="Retorna o nome do produto cadastrado", example = "Doril - 10 mg com 50 comprimidos")
    private String nomeProduct;
	
	@ApiModelProperty(value = "Retorna o valor unitario do produto", example="20.00")
	private BigDecimal precoProduct;
	
	@ApiModelProperty(value = "Retorna o valor total do item com desconto", example="18.01")
    private BigDecimal valorTotalItem;
    
}
