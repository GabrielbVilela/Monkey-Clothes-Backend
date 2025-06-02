package com.monkeyClothes.backend.compra;

import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import com.monkeyClothes.backend.cadastro.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<CompraEntity> listarCompras() {
        return repository.findAll();
    }

    public CompraEntity salvarCompra(CompraEntity compra) {
    	compra.setData(LocalDateTime.now());
        Long clienteCodigo = compra.getCliente().getCodigo();

        ClienteEntity cliente = clienteRepository.findById(clienteCodigo)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com código: " + clienteCodigo));

        compra.setCliente(cliente);

        return repository.save(compra);
    }

    public Optional<CompraEntity> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarCompra(Long id) {
        repository.deleteById(id);
    }
}
