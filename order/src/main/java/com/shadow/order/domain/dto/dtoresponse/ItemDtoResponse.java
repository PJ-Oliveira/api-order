package com.shadow.order.domain.dto.dtoresponse;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ItemDtoResponse {

	private Long id;
	private long id_product;
	private String product_name;
	private int quantidade;
	

}
