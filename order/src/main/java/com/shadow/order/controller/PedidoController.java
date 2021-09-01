package com.shadow.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.models.Product;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class PedidoController {
	
	
	@Autowired
	private final ProductClient productClient;
	
	@GetMapping("products/{id}")
	public Product getProduct(@PathVariable Long id){
		
		return productClient.getById(id);
	}

   

}