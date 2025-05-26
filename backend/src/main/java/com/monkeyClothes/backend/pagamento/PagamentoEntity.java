package com.monkeyClothes.backend.pagamento;

import com.monkeyClothes.backend.status.StatusEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "pagamento")
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private LocalDate data;
    @OneToOne()
    private StatusEntity status;

    public PagamentoEntity() {}
    public PagamentoEntity(StatusEntity status) {
        this.status = status;
    }

}
