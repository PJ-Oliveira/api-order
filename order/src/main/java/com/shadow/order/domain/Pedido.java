package com.shadow.order.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
    @OneToMany
    @Column(name = "desconto_Offer")
    private List<Object> desconto;
    @Column(name = "idOffer")
    private Long id;
    @OneToMany
    @Column(name = "valor_Product")
    private List<Object> product;
    private Date date;
    private BigDecimal total;

}
