package com.monkeyClothes.backend.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService service;

    @GetMapping
    public List<CompraEntity> listar() {
        return service.listarCompras();
    }

    @PostMapping
    public CompraEntity salvar(@RequestBody CompraDTO dto) {
        return service.salvarCompra(dto);
    }
    
    @PutMapping("/{id}")
	public CompraEntity atualizar(@PathVariable Long id, @RequestBody CompraDTO dto) {
		return service.atualizarCompra(id, dto);
	}

}
	
