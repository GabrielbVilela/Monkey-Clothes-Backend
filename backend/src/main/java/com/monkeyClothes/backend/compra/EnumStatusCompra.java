package com.monkeyClothes.backend.compra;

public enum EnumStatusCompra {
    SEPARANDO("separando"),
    TRANSPORTANDO("transportando"),
    SAIU("saiu"),
    ENTREGUE("entregue");

    private String status;

    private EnumStatusCompra(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
