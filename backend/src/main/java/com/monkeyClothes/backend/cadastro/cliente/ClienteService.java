package com.monkeyClothes.backend.cadastro.cliente;

import com.monkeyClothes.backend.cadastro.ProcurarBanco;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public ClienteEntity getClienteNome(String nome) {
        var cliente = repository.findFirstByNomeStartingWithIgnoreCase(nome);
        if (cliente.isPresent()){
            return cliente.get();
        }
        return new ClienteEntity();
    }

    @PostConstruct
    public void init() {
        var cliente1 = new ClienteEntity("Gabriel","123456789");
        var cliente2 = new ClienteEntity("Anthony", "987654321");

        repository.save(cliente1);
        repository.save(cliente2);
    }

    public String criarCliente(ClienteEntity cliente) {
        var clienteCpf = repository.findClienteEntitiesByCpfIgnoreCase(cliente.getCpf());
        if (clienteCpf.isPresent()){
            return "CPF já cadastrado";
        }
        repository.save(cliente);
        return "Cliente cadastrado";

    }
}
