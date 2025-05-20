package com.monkeyClothes.backend.cadastro;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class ProcurarBanco {


    public static <T> T buscarPrimeiroPorCampo(
            String termo,
            Function<String, Optional<T>> metodoBusca,
            Supplier<T> entidadeVazia) {

        return metodoBusca.apply(termo).orElseGet(entidadeVazia);
    }


}
