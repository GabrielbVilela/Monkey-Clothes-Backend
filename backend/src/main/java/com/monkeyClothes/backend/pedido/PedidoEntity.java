package com.monkeyClothes.backend.pedido;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.monkeyClothes.backend.compra.CompraEntity;

@Entity
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private CompraEntity compra;

    private LocalDateTime dataPedido;

    private String status;

    public PedidoEntity() {
        this.dataPedido = LocalDateTime.now(); // seta data atual ao criar
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public CompraEntity getCompra() {
        return compra;
    }

    // Setters
    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }
}
