package com.shadow.order.domain.dto.dtoresponse;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.shadow.order.domain.models.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PedidoDtoResponse {


    private Long idPedido;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itemList;
    private BigDecimal total;
}
