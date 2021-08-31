package com.shadow.order.domain.models;


import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;



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
