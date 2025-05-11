package com.monkeyClothes.backend.cadastro.usuario;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import jakarta.persistence.*;

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
