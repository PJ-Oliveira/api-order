package com.shadow.order.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.ProductDto;
import com.shadow.order.domain.models.Product;

@Service
public class ProductService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductClient productClient;
	


	
	public ProductDto getProduct(Long id) {
		Product product = productClient.getById(id);
		return modelMapper.map(product, ProductDto.class);	
	}
	
	
	

}
