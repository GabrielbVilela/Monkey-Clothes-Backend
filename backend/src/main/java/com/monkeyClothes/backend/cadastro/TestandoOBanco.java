package com.monkeyClothes.backend.cadastro;

import com.monkeyClothes.backend.cadastro.contato.ContatoEntity;
import com.monkeyClothes.backend.cadastro.contato.ContatoRepository;
import com.monkeyClothes.backend.cadastro.endereco.EnderecoEntity;
import com.monkeyClothes.backend.cadastro.endereco.EnderecoRepository;
import com.monkeyClothes.backend.cadastro.cliente.ClienteEntity;
import com.monkeyClothes.backend.cadastro.cliente.ClienteRepository;
import com.monkeyClothes.backend.cadastro.usuario.UsuarioEntity;
import com.monkeyClothes.backend.cadastro.usuario.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestandoOBanco {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ContatoRepository contatoRepository;

    @PostConstruct
    public void testando() {
        var usuario1 = new UsuarioEntity("Gabriel@gmail.com", "12345");
        var usuario2 = new UsuarioEntity("Anthony@gmail.com", "54321");

        var cliente1 = new ClienteEntity("Gabriel","123456789");
        var cliente2 = new ClienteEntity("Anthony","987654321");

        var contato1 = new ContatoEntity("(87)9 9157-9087", cliente1);
        var contato2 = new ContatoEntity("(87)9 9180-1531", cliente2);

        var endereco1 = new EnderecoEntity("Sanharó", "490", cliente1);
        var endereco2 = new EnderecoEntity("Caruaru", "2568", cliente2);

        cliente1.adicionarContato(contato1);
        cliente2.adicionarContato(contato2);
        cliente1.adicionarEndereco(endereco1);
        cliente2.adicionarEndereco(endereco2);
        cliente1.adicionarUsuario(usuario1);
        cliente2.adicionarUsuario(usuario2);

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);

        contatoRepository.save(contato1);
        contatoRepository.save(contato2);

        enderecoRepository.save(endereco1);
        enderecoRepository.save(endereco2);
    }

}
