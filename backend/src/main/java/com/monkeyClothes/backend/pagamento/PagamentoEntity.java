package com.monkeyClothes.backend.pagamento;

import com.monkeyClothes.backend.status.StatusEntity;
import com.monkeyClothes.backend.tipo.TipoEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "pagamento")
public class PagamentoEntity {

//  Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private LocalDate data;

//  Relacionamentos
    @OneToOne()
    private StatusEntity status;
    @OneToOne
    private TipoEntity tipo;

//  Construtores
    public PagamentoEntity() {}
    public PagamentoEntity(StatusEntity status) { this.status = status; }
}
