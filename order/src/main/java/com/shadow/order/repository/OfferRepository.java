package com.shadow.order.repository;

import com.shadow.order.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface OfferRepository extends JpaRepository<Pedido, Long> {


}
