package com.monkeyClothes.backend.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface que estende JpaRepository

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    // Você pode adicionar métodos personalizados aqui, como:
    // List<PedidoEntity> findByStatus(String status);
}
