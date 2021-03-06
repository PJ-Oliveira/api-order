package com.shadow.order.validator;

import java.util.ArrayList;
import java.util.List;

import com.shadow.order.configuration.OfferClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.order.configuration.ProductClientConfig;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.InvalidOrderException;

@Service
public class Validate implements Validator<Pedido>  {
	
	@Autowired
	private  ProductClientConfig productClient;
	@Autowired
	private OfferClientConfig offerClient;

		@Override
		public void validator(Pedido pedido) {
			
			List<Item> itens = new ArrayList<>();
			itens = pedido.getItem();
			for (Item item : itens) {
				try {
					productClient.getById(item.getIdProduct());
				} catch (RuntimeException e) {
					throw new InvalidOrderException("Pedido Inválido");
				}
			}
		}




	

		
	
	
	
}
