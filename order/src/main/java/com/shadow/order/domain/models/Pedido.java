package com.shadow.order.domain.models;

import java.io.Serializable;
import java.math.BigDecimal;
<<<<<<< HEAD
=======

import java.util.ArrayList;
>>>>>>> 61ee44e00609cad064417102389530ba6c62d4dc
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.Persister;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_pedido")
@ToString
@Builder
public class Pedido implements Serializable {

<<<<<<< HEAD
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Embedded
	private List<Item> item;
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEDIDO_ID")
    private Long idPedido;
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.MERGE)
    @Column(name = "ITEM")
    private List<Item> item;
    @Column(name = "TOTAL")
>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb
    private BigDecimal total;

}