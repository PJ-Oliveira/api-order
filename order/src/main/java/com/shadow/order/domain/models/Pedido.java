package com.shadow.order.domain.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Long idPedido;
	
    @OneToMany(cascade =  CascadeType.ALL)
    private List<Item> item;
    
    
    private BigDecimal totalPedido;

}