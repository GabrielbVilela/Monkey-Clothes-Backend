package com.monkeyClothes.backend.status;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

//  Repositorios
    @Autowired
    private StatusRepository repository;

//  Metodo com valores iniciais
    @PostConstruct
    public void init() {
        repository.save(new StatusEntity("Aguardando pagamento"));
        repository.save(new StatusEntity("Aguardando aprovação do pagamento"));
        repository.save(new StatusEntity("Pagamento aprovado"));
        repository.save(new StatusEntity("Compra sendo separada"));
        repository.save(new StatusEntity("Compra em trânsito"));
        repository.save(new StatusEntity("Compra saiu para entrega"));
        repository.save(new StatusEntity("Compra entregue"));
    }

    public StatusEntity getStatus(long id) {
        var statusEntity = repository.findById(id);
        return statusEntity.orElse(null);
    }

}
