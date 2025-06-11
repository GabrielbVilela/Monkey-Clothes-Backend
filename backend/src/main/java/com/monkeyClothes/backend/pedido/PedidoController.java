package com.monkeyClothes.backend.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define esta classe como um controller REST
@RequestMapping("/pedidos") // Define o prefixo da URL para todos os endpoints
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired // Injeta o service no controller
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Endpoint para criar um novo pedido
    @PostMapping
    public ResponseEntity<PedidoEntity> criarPedido(@RequestBody PedidoEntity pedido) {
        PedidoEntity novoPedido = pedidoService.salvarPedido(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    // Endpoint para listar todos os pedidos
    @GetMapping
    public ResponseEntity<List<PedidoEntity>> listarPedidos() {
        List<PedidoEntity> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    // Endpoint para buscar um pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoEntity> buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar um pedido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
