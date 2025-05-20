package com.monkeyClothes.backend.cadastro.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public UsuarioEntity get(@RequestBody UsuarioEntity usuario) {
        return service.getUsuario(usuario.getEmail());
    }

    @PostMapping
    public String post() {
        return "email";
    }

    @PutMapping
    public String put() {
        return "put";
    }

    @DeleteMapping
    public void delete() {}
}
