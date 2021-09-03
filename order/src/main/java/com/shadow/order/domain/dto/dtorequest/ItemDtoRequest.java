package com.shadow.order.domain.dto.dtorequest;


import com.shadow.order.domain.models.Offer;
import com.shadow.order.domain.models.Product;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemDtoRequest {

    @Column(name = "OFFER_ID")
    private Long idOffer;
    //@Column(name = "OFFER_FIM")
    /*@Future
    private LocalDate fim;
    @Column(name = "DESCONTO")*/
    private BigDecimal desconto;
    @Column(name = "PRODUCT_ID")
    private Long idProduct;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "PRECO")
    private BigDecimal totalItens;
    private BigDecimal preco;

}
