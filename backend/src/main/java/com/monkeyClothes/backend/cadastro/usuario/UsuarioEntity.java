package com.monkeyClothes.backend.cadastro.usuario;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import jakarta.persistence.*;

@Entity(name = "usuario")
public class UsuarioEntity {

//  Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(nullable = false)
    private boolean admin;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    @OneToOne(mappedBy = "usuario")
    private ClienteEntity cliente;

//  2 Construtores (1 - vazio, 2 - Com Email e senha)
    public UsuarioEntity() {}
    public UsuarioEntity(String email, String senha, boolean isAdmin) { this.email = email; this.senha = senha; this.admin = isAdmin; }

//  Getters
    public long getCodigo() { return codigo; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public boolean isAdmin() { return admin; }

//  Setters
    public void setCliente(ClienteEntity cliente) { this.cliente = cliente; }
}
