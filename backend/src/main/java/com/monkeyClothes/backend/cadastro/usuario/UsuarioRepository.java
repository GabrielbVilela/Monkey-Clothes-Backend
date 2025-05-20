package com.monkeyClothes.backend.cadastro.usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findUsuarioEntityByEmailIgnoreCase(String email);
}
