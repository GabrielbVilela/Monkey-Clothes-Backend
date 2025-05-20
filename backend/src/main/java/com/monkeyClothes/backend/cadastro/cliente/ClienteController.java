package com.monkeyClothes.backend.cadastro.cliente;

import com.monkeyClothes.backend.cadastro.ProcurarBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ClienteEntity get(@RequestBody ClienteEntity cliente) {
        return service.getClienteNome(cliente.getNome());
    }

    @PostMapping
    public String post(@RequestBody ClienteEntity cliente) {
        return service.criarCliente(cliente);
    }

    @PutMapping
    public void put() {}

    @DeleteMapping
    public void delete() {}
}
