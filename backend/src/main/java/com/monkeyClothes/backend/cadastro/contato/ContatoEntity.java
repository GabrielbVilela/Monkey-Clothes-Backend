package com.monkeyClothes.backend.cadastro.contato;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
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

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
