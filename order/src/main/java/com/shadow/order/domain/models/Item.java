
package com.shadow.order.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Item {

    
    private Long id;
    private Long id_product;
    private String product_name;
    //private BigDecimal precoProduct;
    private int quantidade;
    //private BigDecimal total;
   





}