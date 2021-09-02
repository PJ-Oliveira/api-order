package com.shadow.order.domain.dto.dtorequest;

<<<<<<< HEAD
import lombok.Data;
=======
import com.shadow.order.domain.models.Item;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Persistent;
>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb



@Data
public class PedidoDtoRequest {

<<<<<<< HEAD
   
=======

    private List<Item> item;
    private BigDecimal total;
>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb

}
