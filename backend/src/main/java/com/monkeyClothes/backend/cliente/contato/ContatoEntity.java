package com.monkeyClothes.backend.cliente.contato;

import com.monkeyClothes.backend.cliente.model.ClienteEntity;
import jakarta.persistence.*;

@Entity(name = "contato")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(nullable = false,unique = true)
    private String numero;
    @ManyToOne
    private ClienteEntity cliente;

    public ContatoEntity() {}

    public ContatoEntity(String numero) {
        this.numero = numero;
    }
}
