package com.shadow.order.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "td_item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
	
	@OneToOne
	private Offer offer;
    
	@OneToOne
    private Product product;



}
