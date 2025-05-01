package com.monkeyClothes.backend.pagamento;

public enum EnumTipoPagamento {
    DEBITO("debito"), CREDITO("credito"), PIX("pix"), BOLETO("boleto");
    private String tipo;

    private EnumTipoPagamento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
