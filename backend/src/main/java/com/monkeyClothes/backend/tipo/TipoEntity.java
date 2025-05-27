package com.monkeyClothes.backend.tipo;

import com.monkeyClothes.backend.pagamento.PagamentoEntity;
import jakarta.persistence.*;

@Entity(name = "tipo")
public class TipoEntity {

//  Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String tipo;

//  Relacionamentos
    @OneToOne(mappedBy = "tipo")
    private PagamentoEntity pagamento;

//  Contrutores
    public TipoEntity() {}
    public TipoEntity(String tipo) { this.tipo = tipo; }
}
