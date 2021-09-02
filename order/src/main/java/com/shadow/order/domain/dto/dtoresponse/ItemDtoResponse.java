package com.shadow.order.domain.dto.dtoresponse;


import com.shadow.order.domain.models.Offer;
import com.shadow.order.domain.models.Product;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemDtoResponse {

    private Long idItem;
    private Long idOffer;
    private BigDecimal desconto;
    private Long idProduct;
    private String nome;
    private BigDecimal totalItens;
    private BigDecimal preco;
}
