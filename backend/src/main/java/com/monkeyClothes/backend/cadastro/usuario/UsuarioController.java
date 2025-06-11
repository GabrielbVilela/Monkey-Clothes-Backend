package com.monkeyClothes.backend.cadastro.usuario;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioEntity> get() {
        return service.getUsuario();
    }

    @PostMapping
    public UsuarioEntity validarLogin(@RequestBody UsuarioEntity usuario) {
        return service.login(usuario);
    }

    @PutMapping
    public String put() {
        return "put";
    }

    @DeleteMapping
    public void delete() {}
}
