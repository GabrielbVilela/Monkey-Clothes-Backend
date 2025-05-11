package com.monkeyClothes.backend.cadastro.usuario;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @GetMapping
    public String get() { return "Get usuario"; }

    @PostMapping
    public void post() {}

    @PutMapping
    public void put() {}

    @DeleteMapping
    public void delete() {}
}
