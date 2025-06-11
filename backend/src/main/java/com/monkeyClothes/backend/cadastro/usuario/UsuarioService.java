package com.monkeyClothes.backend.cadastro.usuario;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioEntity> getUsuario() {
        var usuario = repository.findAll();
        return usuario;
    }

    @PostConstruct
    public void init() {
        var usuario1 = new UsuarioEntity("Gabriel@gmail.com", "12345", true);
        var usuario2 = new UsuarioEntity("Anthony@gmail.com", "54321", false);
        repository.save(usuario1);
        repository.save(usuario2);
    }

    public UsuarioEntity login(UsuarioEntity usuarioLogin) {
        var usuario = repository.findUsuarioEntityByEmailIgnoreCase(usuarioLogin.getEmail());
        if (!usuario.isPresent()) {
            throw new NoSuchElementException("Usuário não encontrado com o email: " + usuarioLogin.getEmail());
        }
        if (!usuario.get().getSenha().equals(usuarioLogin.getSenha())) {
            throw new IllegalArgumentException("Senha incorreta");
        }
        return usuario.get();
    }
}
