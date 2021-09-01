package com.shadow.order.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idItem;
    private Offer offer;
    private Product product;



}
