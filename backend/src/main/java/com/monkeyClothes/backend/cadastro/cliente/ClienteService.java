package com.monkeyClothes.backend.cadastro.cliente;

import com.monkeyClothes.backend.cadastro.usuario.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ClienteEntity> getCliente() {
        return repository.findAll();
    }

    @PostConstruct
    public void init() {
        var cliente1 = new ClienteEntity("Gabriel","123456789");
        var cliente2 = new ClienteEntity("Anthony", "987654321");

        repository.save(cliente1);
        repository.save(cliente2);
    }

    public ClienteEntity criarCliente(ClienteEntity cliente) {
        var consultaCpf = repository.findClienteEntitiesByCpfIgnoreCase(cliente.getCpf());
        if (consultaCpf.isPresent()){
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        var consultaEmail = usuarioRepository.findUsuarioEntityByEmailIgnoreCase(cliente.getUsuario().getEmail());
        if (consultaEmail.isPresent()){
            throw new IllegalArgumentException("Email já cadastrado");
        }
        usuarioRepository.save(cliente.getUsuario());
        repository.save(cliente);
        return cliente;

    }
}
