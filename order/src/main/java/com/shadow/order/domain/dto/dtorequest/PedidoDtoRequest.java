package com.shadow.order.domain.dto.dtorequest;

import com.shadow.order.domain.models.Item;
import lombok.*;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDtoRequest {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itemList;
    private BigDecimal total;
    @NonNull
    private Long idOffer;
    @NonNull
    private Long idProduct;



}
