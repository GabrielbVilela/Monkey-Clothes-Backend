package com.monkeyClothes.backend.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoEntity> criarPedido(@RequestBody PedidoEntity pedido) {
        PedidoEntity novoPedido = pedidoService.salvarPedido(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoEntity>> listarPedidos() {
        List<PedidoEntity> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoEntity> buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoEntity> atualizarPedido(@PathVariable Long id, @RequestBody PedidoEntity pedidoAtualizado) {
        var pedidoExistenteOpt = pedidoService.buscarPorId(id);
        if (pedidoExistenteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        PedidoEntity pedidoExistente = pedidoExistenteOpt.get();

        pedidoExistente.setDataPedido(pedidoAtualizado.getDataPedido());
        pedidoExistente.setStatus(pedidoAtualizado.getStatus());
        pedidoExistente.setCompra(pedidoAtualizado.getCompra());

        PedidoEntity pedidoAtualizadoSalvo = pedidoService.salvarPedido(pedidoExistente);

        return ResponseEntity.ok(pedidoAtualizadoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
