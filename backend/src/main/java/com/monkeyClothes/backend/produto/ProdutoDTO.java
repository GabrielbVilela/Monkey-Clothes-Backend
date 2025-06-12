package com.monkeyClothes.backend.produto;

import java.math.BigDecimal;

public class ProdutoDTO {

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque;
    private String urlImagem;

    public ProdutoDTO(String nome, String descricao, BigDecimal preco, Integer estoque, String urlImagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.urlImagem = urlImagem;
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

    public ProdutoEntity toEntity() {
        return new ProdutoEntity(nome, descricao, preco, estoque, urlImagem);
    }
}
