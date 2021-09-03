package com.shadow.order.repository;

import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
