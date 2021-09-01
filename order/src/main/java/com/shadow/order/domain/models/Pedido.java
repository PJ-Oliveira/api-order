package com.shadow.order.domain.models;

import java.math.BigDecimal;
import java.util.List;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


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
    @GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< HEAD
    private Long id;
    
    @OneToMany
    private List<Item> item;
    
=======
    private Long idPedido;
    @OneToMany
    @JoinColumn(name = "pedido_id")
    @NotNull
    private List<Item> item;

>>>>>>> bbf5179a3b3d444630d0e3d53dc12a9aa56cfe6b
    private BigDecimal total;


}