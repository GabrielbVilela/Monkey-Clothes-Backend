package com.monkeyClothes.backend.cadastro.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public String get() { return "Get contato"; }

    @PostMapping
    public void post() {}

    @PutMapping
    public void put() {}

    @DeleteMapping
    public void delete() {}
}
