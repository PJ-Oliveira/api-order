package com.shadow.order.domain.dto.dtoresponse;

<<<<<<< HEAD
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ItemDtoResponse {

	private Long id;
	private long id_product;
	private String product_name;
	private int quantidade;
	

=======

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

    @Column(name = "OFFER_ID")
    private Long idOffer;
    @Column(name = "DESCONTO")
    private BigDecimal desconto;
    @Column(name = "PRODUCT_ID")
    private Long idProduct;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "PRECO")
    private BigDecimal totalItens;
    private BigDecimal preco;
>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb
}
