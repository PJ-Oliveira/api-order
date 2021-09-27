package com.shadow.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shadow.order.domain.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
