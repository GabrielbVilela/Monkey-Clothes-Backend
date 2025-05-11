package com.monkeyClothes.backend.cadastro.cliente;

import com.monkeyClothes.backend.cadastro.contato.ContatoEntity;
import com.monkeyClothes.backend.cadastro.endereco.EnderecoEntity;
import com.monkeyClothes.backend.cadastro.usuario.UsuarioEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    @OneToMany(mappedBy = "cliente")
    private List<ContatoEntity> contatos = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    private List<EnderecoEntity> enderecos = new ArrayList<>();
    @OneToOne
    private UsuarioEntity usuario;

    public ClienteEntity() {}

    public ClienteEntity(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adicionarContato(ContatoEntity contato) {
        this.contatos.add(contato);
        contato.setCliente(this);
    }

    public void adicionarEndereco(EnderecoEntity endereco) {
        this.enderecos.add(endereco);
        endereco.setCliente(this);
    }

    public void adicionarUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
