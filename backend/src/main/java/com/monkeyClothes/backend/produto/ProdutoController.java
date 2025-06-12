package com.monkeyClothes.backend.produto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> criar(@RequestBody ProdutoDTO dto) {
        ProdutoEntity salvo = produtoService.salvar(dto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        ProdutoEntity atualizado = produtoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

}
