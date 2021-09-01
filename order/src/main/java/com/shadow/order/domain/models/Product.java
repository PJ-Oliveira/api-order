package com.shadow.order.domain.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
<<<<<<< HEAD
@Table(name = "tb_produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
=======
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
>>>>>>> bbf5179a3b3d444630d0e3d53dc12a9aa56cfe6b
    private String nome;
    private BigDecimal preco;

}