package com.monkeyClothes.backend.cadastro.endereco;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @GetMapping
    public String get() { return "Get endereco"; }

    @PostMapping
    public void post() {}

    @PutMapping
    public void put() {}

    @DeleteMapping
    public void delete() {}
}
