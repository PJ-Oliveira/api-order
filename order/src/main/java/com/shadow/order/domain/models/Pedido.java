package com.shadow.order.domain.models;

<<<<<<< HEAD

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

=======
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> dev001


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
    @Column(name = "idOffer")
    private Long idOffer;
    @Column(name = "idProduto")
    private Long idProduct;
    private Date date;
    private BigDecimal total;

}
