package com.monkeyClothes.backend.status;

import com.monkeyClothes.backend.compra.CompraEntity;
import com.monkeyClothes.backend.pagamento.PagamentoEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity(name = "status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String status;

    @OneToOne(mappedBy = "status")
    private PagamentoEntity pagamento;

    @OneToMany(mappedBy = "status")
    private List<CompraEntity> compras;

    public StatusEntity() {}

    public StatusEntity(String status) {
        this.status = status;
    }

}
