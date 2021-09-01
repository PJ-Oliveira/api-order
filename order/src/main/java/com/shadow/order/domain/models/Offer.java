package com.shadow.order.domain.models;


import java.math.BigDecimal;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
=======
import java.util.Date;

>>>>>>> bbf5179a3b3d444630d0e3d53dc12a9aa56cfe6b

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
@Entity
@Table(name = "tb_offer")
public class Offer {

 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
=======

@Entity
public class Offer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull

    private Long idOffer;
    @NotNull
>>>>>>> bbf5179a3b3d444630d0e3d53dc12a9aa56cfe6b
    private BigDecimal desconto;
    @NotNull
    private Date inicio;
    @NotNull
    private Date fim;
    private String descricao;

}