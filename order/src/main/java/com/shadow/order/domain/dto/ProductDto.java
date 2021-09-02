package com.shadow.order.domain.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {
	
	 	private Long id;
	    private String nome;
	    private BigDecimal preco;

}
