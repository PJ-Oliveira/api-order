package com.shadow.order.domain.dto.dtorequest;



import lombok.*;
import javax.persistence.Column;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemDtoRequest {

    @Column(name = "OFFER_ID")
    private Long idOffer;
    private BigDecimal desconto;
    @Column(name = "PRODUCT_ID")
    private Long idProduct;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "PRECO")
    private BigDecimal totalItens;
    private BigDecimal preco;

}
