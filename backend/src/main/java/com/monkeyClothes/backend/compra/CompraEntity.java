package com.monkeyClothes.backend.compra;

import com.monkeyClothes.backend.status.StatusEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import com.monkeyClothes.backend.pagamento.PagamentoEntity;
import com.monkeyClothes.backend.pedido.PedidoEntity;

@Entity(name = "compra")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private Double valor;
    private LocalDateTime data;

    @OneToOne
    private StatusEntity status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

//    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PedidoEntity> pedidos;
//
//    @OneToOne(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
//    private PagamentoEntity pagamento;

    public CompraEntity() {}
    // Getters e Setters

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusEntity getStatus() {
        return this.status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public ClienteEntity getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}