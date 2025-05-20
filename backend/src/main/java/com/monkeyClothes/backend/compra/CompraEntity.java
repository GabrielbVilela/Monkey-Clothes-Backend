package com.monkeyClothes.backend.compra;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import com.monkeyClothes.backend.pagamento.PagamentoEntity;
import com.monkeyClothes.backend.pedido.PedidoEntity;

@Entity(name = "Compra")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private Double valor;
    private String status;


    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

   //@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<PedidoEntity> pedidos;

   // @OneToOne(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
   // private PagamentoEntity pagamento;

    public CompraEntity() {}
}
