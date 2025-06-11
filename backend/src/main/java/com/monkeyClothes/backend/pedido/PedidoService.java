package com.monkeyClothes.backend.pedido;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

// Classe responsável pela lógica de negócio dos pedidos
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired // Injeta automaticamente o repositório no serviço
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Cria ou atualiza um pedido
    public PedidoEntity salvarPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    // Busca todos os pedidos cadastrados
    public List<PedidoEntity> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // Busca um pedido específico pelo ID
    public Optional<PedidoEntity> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Exclui um pedido pelo ID
    public void deletarPorId(Long id) {
        pedidoRepository.deleteById(id);
    }
}
