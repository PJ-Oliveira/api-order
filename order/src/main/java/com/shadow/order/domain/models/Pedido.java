package com.shadow.order.domain.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Pedido")
    private Long id;
    @OneToMany
    @Column(name = "desconto_Offer")
    private List<Object> desconto;
    @OneToMany
    @Column(name = "valor_Product")
    private List<Object> product;
    private Date date;
    private BigDecimal total;

}
