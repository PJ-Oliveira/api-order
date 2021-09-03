package com.shadow.order.domain.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;


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
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.MERGE)
    @Column(name = "ITEM")
    private List<Item> item;
    @Column(name = "TOTAL")
    private BigDecimal total;

}