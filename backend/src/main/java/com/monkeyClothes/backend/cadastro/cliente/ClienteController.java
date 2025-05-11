package com.monkeyClothes.backend.cadastro.cliente;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @GetMapping
    public String get() { return "Get de cliente"; }

    @PostMapping
    public void post() {}

    @PutMapping
    public void put() {}

    @DeleteMapping
    public void delete() {}
}
