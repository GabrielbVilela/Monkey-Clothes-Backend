package com.monkeyClothes.backend.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

//  Repositorios
    @Autowired
    private PagamentoRepository repository;
}
