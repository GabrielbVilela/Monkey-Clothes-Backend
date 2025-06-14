package com.monkeyClothes.backend.cadastro.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteEntity> get() {
        return service.getCliente();
    }

    @PostMapping
    public ClienteEntity post(@RequestBody ClienteEntity cliente) {
        return service.criarCliente(cliente);
    }

    @PutMapping("/{codigo}")
    public ClienteEntity put(@PathVariable long codigo, @RequestBody ClienteEntity clienteAtualizado) {
        return service.atualizarCliente(codigo, clienteAtualizado);
    }

    @DeleteMapping
    public void delete() {}
}
