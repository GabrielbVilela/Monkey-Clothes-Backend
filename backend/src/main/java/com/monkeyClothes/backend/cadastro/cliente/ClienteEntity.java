package com.monkeyClothes.backend.cadastro.cliente;

import com.monkeyClothes.backend.cadastro.contato.ContatoEntity;
import com.monkeyClothes.backend.cadastro.endereco.EnderecoEntity;
import com.monkeyClothes.backend.cadastro.usuario.UsuarioEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "cliente")
public class ClienteEntity {

//  Atributos
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

//  2 Construtores (1 - Vazio; 2 - Com os parametros [nome, CPF])
    public ClienteEntity() {}
    public ClienteEntity(String nome, String cpf) { this.nome = nome; this.cpf = cpf; }

//  Getters
    public long getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public List<ContatoEntity> getContatos() { return contatos;}
    public List<EnderecoEntity> getEnderecos() { return enderecos;}
    public UsuarioEntity getUsuario() { return usuario; }

//  Métodos para criar o relacionamento entre a classe cliente e as classes de seus atributos.
    public void adicionarContato(ContatoEntity contato) { this.contatos.add(contato);}
    public void adicionarEndereco(EnderecoEntity endereco) { this.enderecos.add(endereco);}
    public void adicionarUsuario(UsuarioEntity usuario) { this.usuario = usuario; usuario.setCliente(this);}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
