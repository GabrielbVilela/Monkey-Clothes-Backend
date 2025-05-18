package com.monkeyClothes.backend.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepository repository;

    @GetMapping
    public List<CompraEntity> listar() {
        return repository.findAll();
    }

    @PostMapping
    public CompraEntity salvar(@RequestBody CompraEntity compra) {
        return repository.save(compra);
    }
}
