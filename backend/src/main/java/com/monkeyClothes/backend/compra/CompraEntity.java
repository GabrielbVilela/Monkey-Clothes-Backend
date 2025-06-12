package com.monkeyClothes.backend.compra;

import com.monkeyClothes.backend.status.StatusEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;

@Entity(name = "compra")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private Double valor;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    public CompraEntity() {}

    public CompraEntity(Double valor, StatusEntity status, ClienteEntity cliente) {
        this.valor = valor;
        this.data = LocalDateTime.now();
        this.status = status;
        this.cliente = cliente;
    }

    //Getters
    public Long getCodigo() {
        return codigo;
    }

    public Double getValor() {
        return valor;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }
    
    //setters para update
    
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

}


