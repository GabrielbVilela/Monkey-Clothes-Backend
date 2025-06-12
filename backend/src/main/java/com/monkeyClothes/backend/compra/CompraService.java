package com.monkeyClothes.backend.compra;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import com.monkeyClothes.backend.cadastro.cliente.ClienteRepository;
import com.monkeyClothes.backend.status.StatusEntity;
import com.monkeyClothes.backend.status.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private StatusRepository statusRepository;

    public List<CompraEntity> listarCompras() {
        return repository.findAll();
    }

    public CompraEntity salvarCompra(CompraDTO dto) {
        ClienteEntity cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com código: " + dto.getClienteId()));

        StatusEntity status = statusRepository.findById(dto.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status não encontrado com ID: " + dto.getStatusId()));

        CompraEntity compra = new CompraEntity(dto.getValor(), status, cliente);

        return repository.save(compra);
    }

    public Optional<CompraEntity> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarCompra(Long id) {
        repository.deleteById(id);
    }
    public CompraEntity atualizarCompra(Long id, CompraDTO dto) {
        CompraEntity compra = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra não encontrada com ID: " + id));

        StatusEntity status = statusRepository.findById(dto.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status não encontrado com ID: " + dto.getStatusId()));

        ClienteEntity cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com código: " + dto.getClienteId()));

        compra.setValor(dto.getValor());
        compra.setStatus(status);
        compra.setCliente(cliente);

        return repository.save(compra);
    }

}
