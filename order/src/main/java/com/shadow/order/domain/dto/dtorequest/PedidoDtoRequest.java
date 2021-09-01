package com.shadow.order.domain.dto.dtorequest;

import com.shadow.order.domain.models.Item;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDtoRequest {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itemList;
    private BigDecimal total;


}
