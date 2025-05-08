package com.monkeyClothes.backend.cliente.usuario;

import com.monkeyClothes.backend.cliente.contato.ContatoEntity;
import com.monkeyClothes.backend.cliente.endereco.EnderecoEntity;
import com.monkeyClothes.backend.cliente.model.ClienteEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    @OneToOne(mappedBy = "usuario")
    private ClienteEntity cliente;


    public UsuarioEntity() {}

    public UsuarioEntity(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
