package com.monkeyClothes.backend.cadastro.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findFirstByNomeStartingWithIgnoreCase(String nome);

    Optional<ClienteEntity> findClienteEntitiesByCpfIgnoreCase(String cpf);
}
