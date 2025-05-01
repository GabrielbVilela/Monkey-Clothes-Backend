package com.monkeyClothes.backend.usuario;

public enum EnumTipoUsuario {
    ADMINISTRADOR("administrador"), USUARIO("usuario"), FUNCIONARIO("funcionario");
    private String tipo;

    private EnumTipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
