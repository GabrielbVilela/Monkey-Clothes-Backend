package com.monkeyClothes.backend.cadastro.usuario;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioEntity getUsuario(String login) {
        var usuario = repository.findUsuarioEntityByEmailIgnoreCase(login);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        return new UsuarioEntity();
    }

    public String cadastro(UsuarioEntity usuario) {
        if (repository.findUsuarioEntityByEmailIgnoreCase(usuario.getEmail()).isPresent()) {
            return "Usuario já cadastrado";
        }
        repository.save(usuario);
        return "Cadastrado com sucesso";
    }

    @PostConstruct
    public void init() {
        var usuario1 = new UsuarioEntity("Gabriel@gmail.com", "12345");
        var usuario2 = new UsuarioEntity("Anthony@gmail", "54321");
        repository.save(usuario1);
        repository.save(usuario2);
    }
}
