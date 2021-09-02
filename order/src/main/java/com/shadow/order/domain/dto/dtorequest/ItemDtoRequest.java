package com.shadow.order.domain.dto.dtorequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDtoRequest {
	
	
	private Long id_product;
    private String product_name;
    private int quantidade;
    

}
