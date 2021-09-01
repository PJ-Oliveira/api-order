package com.shadow.order.domain.models;

import lombok.Data;

@Data
public class Item {

    private Long idItem;
    private Offer offer;
    private Product product;



}
