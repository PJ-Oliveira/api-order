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
@Getter
@Setter
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Pedido")
    private Long id;
    @OneToMany
    @Column(name = "desconto_Offer")
    private List<BigDecimal> desconto;
    @OneToMany
    @Column(name = "valor_Product")
    private List<BigDecimal> product;
    private Date date;
    private String descricao;
    private BigDecimal total;


}
