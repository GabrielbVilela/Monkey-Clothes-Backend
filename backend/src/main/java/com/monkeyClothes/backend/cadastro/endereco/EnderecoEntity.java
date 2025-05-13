package com.monkeyClothes.backend.cadastro.endereco;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import jakarta.persistence.*;

@Entity(name = "endereco")
public class EnderecoEntity {

//  Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    @ManyToOne
    private ClienteEntity cliente;

//  2 Construtores (1 - Vazio; 2 - Com os parametros [cidade, numero])
    public EnderecoEntity() {}
    public EnderecoEntity(String cidade, String numero, ClienteEntity cliente) { this.cidade = cidade; this.numero = numero; this.cliente = cliente; }

//  Getters
    public long getId() { return id; }
    public String getCep() { return cep; }
    public String getLogradouro() { return logradouro; }
    public String getNumero() { return numero; }
    public String getComplemento() { return complemento; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }

}
