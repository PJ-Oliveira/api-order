package com.shadow.order.repository;

import com.shadow.order.domain.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    
}
