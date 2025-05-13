package com.monkeyClothes.backend.cadastro.usuario;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import jakarta.persistence.*;

@Entity(name = "usuario")
public class UsuarioEntity {

//  Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    @OneToOne(mappedBy = "usuario")
    private ClienteEntity cliente;

//  2 Construtores (1 - vazio, 2 - Com Email e senha)
    public UsuarioEntity() {}
    public UsuarioEntity(String email, String senha) { this.email = email; this.senha = senha; }

//  Getters
    public long getCodigo() { return codigo; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
}
