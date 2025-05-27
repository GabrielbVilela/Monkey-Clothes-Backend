package com.monkeyClothes.backend.tipo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoService {

//  Repositorios
    @Autowired
    private TipoRepository repository;

//  Metodo com valores iniciais
    @PostConstruct
    public void init() {
        repository.save(new TipoEntity("Pagamento por débito"));
        repository.save(new TipoEntity("Pagamento por crédito"));
        repository.save(new TipoEntity("Pagamento por pix"));
        repository.save(new TipoEntity("Pagamento por boleto"));
    }
}
