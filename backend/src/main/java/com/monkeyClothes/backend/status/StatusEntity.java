package com.monkeyClothes.backend.status;

import com.monkeyClothes.backend.compra.CompraEntity;
import com.monkeyClothes.backend.pagamento.PagamentoEntity;
import jakarta.persistence.*;

@Entity(name = "status")
public class StatusEntity {

//  Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String status;

//  Relacionamentos
    @OneToOne(mappedBy = "status")
    private PagamentoEntity pagamento;
    @OneToOne(mappedBy = "status")
    private CompraEntity compraEntity;

//  Construtores
    public StatusEntity() {}
    public StatusEntity(String status) { this.status = status; }
}
