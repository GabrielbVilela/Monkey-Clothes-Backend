package com.monkeyClothes.backend.produto;

public enum EnumTipoProduto {
    PARTESUPERIOR("parte inferior"), PARTEINFERIOR("parte superior"), CALCADO("calcado");
    private String descricao;


    private EnumTipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
