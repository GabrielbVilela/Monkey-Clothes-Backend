package com.monkeyClothes.backend.cadastro.endereco;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import jakarta.persistence.*;

@Entity(name = "endereco")
public class EnderecoEntity {
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

    public EnderecoEntity() {}

    public EnderecoEntity(String cidade, String numero) {
        this.cidade = cidade;
        this.numero = numero;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
