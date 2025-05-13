package com.monkeyClothes.backend.cadastro.contato;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import jakarta.persistence.*;

@Entity(name = "contato")
public class ContatoEntity {

//  Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(nullable = false,unique = true)
    private String numero;
    @ManyToOne
    private ClienteEntity cliente;

//  2 Construtores (1 - Vazio, 2 - Com os parametros [numero, cliente])
    public ContatoEntity() {}
    public ContatoEntity(String numero, ClienteEntity cliente) { this.numero = numero; this.cliente = cliente; }

//  Getters
    public long getCodigo() { return codigo; }
    public String getNumero() { return numero; }
    public ClienteEntity puxarCliente() { return cliente; }

}
