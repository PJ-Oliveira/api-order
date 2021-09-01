
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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
<<<<<<< HEAD
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
=======
@Table(name = "tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long idItem;
    @OneToOne
    @NotNull
    private Offer offer;
    @OneToOne
>>>>>>> bbf5179a3b3d444630d0e3d53dc12a9aa56cfe6b
    private Product product;
    private BigDecimal total;





}