package com.monkeyClothes.backend.pagamento;

public enum EnumStatusPagamento {
    PAGO("pago"),
    AGUARDANDOPAGAMENTO("aguardando pagamento"),
    AGUARDANDOAPROVACAO("aguardando aprovacao");

    private String Status;

    private EnumStatusPagamento(String Status) {
        this.Status = Status;
    }
    public String getStatus() {
        return Status;
    }

}
