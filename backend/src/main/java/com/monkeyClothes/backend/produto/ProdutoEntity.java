package com.monkeyClothes.backend.produto;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column(nullable = false)
    private final String nome;

    @Column(length = 1000)
    private final String descricao;

    @Column(nullable = false)
    private final BigDecimal preco;

    @Column(nullable = false)
    private final Integer estoque;

    @Column(name = "url_imagem")
    private final String urlImagem;

    // Construtor vazio para JPA
    protected ProdutoEntity() {
        this.id = null;
        this.nome = null;
        this.descricao = null;
        this.preco = null;
        this.estoque = null;
        this.urlImagem = null;
    }

    // Construtor completo, exceto o ID
    public ProdutoEntity(String nome, String descricao, BigDecimal preco, Integer estoque, String urlImagem) {
        this.id = null; // será atribuído pelo banco
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.urlImagem = urlImagem;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
}
