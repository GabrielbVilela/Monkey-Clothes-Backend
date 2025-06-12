package com.monkeyClothes.backend.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoEntity salvarPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<PedidoEntity> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoEntity> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        pedidoRepository.deleteById(id);
    }
}
