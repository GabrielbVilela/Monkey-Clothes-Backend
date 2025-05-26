package com.monkeyClothes.backend.compra;

import com.monkeyClothes.backend.status.StatusEntity;
import jakarta.persistence.*;
import java.time.LocalDate;
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
    private LocalDate data;

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
}
