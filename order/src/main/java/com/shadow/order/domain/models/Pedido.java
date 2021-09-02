package com.shadow.order.domain.models;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEDIDO_ID")
    private Long idPedido;
    @Embedded
    @AttributeOverrides
            ({@AttributeOverride(name = "idOffer", column = @Column(name = "OFFER_ID")),
            @AttributeOverride(name = "desconto", column = @Column(name = "DESCONTO")),
            @AttributeOverride(name = "idProduct", column = @Column(name = "PRODUCT_ID")),
            @AttributeOverride(name = "nome", column = @Column(name = "NOME")),
            @AttributeOverride(name = "totalItens", column = @Column(name = "totalItens")),
            @AttributeOverride(name = "preco", column = @Column(name = "PRECO"))})
    @Column(name = "ITENS")
    private List<Item> item;
    @Column(name = "TOTAL")
    private BigDecimal total;


}