package com.shadow.order.domain.models;


import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itemList;
    private BigDecimal total;

}
