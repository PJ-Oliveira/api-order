package com.shadow.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadow.order.domain.dto.ProductDto;
import com.shadow.order.service.ProductService;

@RestController
@RequestMapping("/order/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Long id){
		ProductDto productDto = productService.getProduct(id);
		return ResponseEntity.ok().body(productDto);
		
	}
}
