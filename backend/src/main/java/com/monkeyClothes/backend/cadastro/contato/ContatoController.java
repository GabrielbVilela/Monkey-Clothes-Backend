package com.monkeyClothes.backend.cadastro.contato;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @GetMapping
    public String get() { return "Get contato"; }

    @PostMapping
    public void post() {}

    @PutMapping
    public void put() {}

    @DeleteMapping
    public void delete() {}
}
