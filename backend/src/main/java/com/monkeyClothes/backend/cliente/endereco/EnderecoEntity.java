package com.monkeyClothes.backend.cliente.endereco;

import com.monkeyClothes.backend.cliente.model.ClienteEntity;
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
}
