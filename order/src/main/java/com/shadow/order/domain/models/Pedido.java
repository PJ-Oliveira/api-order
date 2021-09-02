package com.shadow.order.domain.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_pedido")
public class Pedido {

   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Embedded
	private List<Item> item;
    private BigDecimal total;


}