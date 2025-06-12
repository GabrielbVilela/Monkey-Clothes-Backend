package com.monkeyClothes.backend.cadastro.cliente;

import com.monkeyClothes.backend.cadastro.usuario.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ClienteEntity> getCliente() {
        return repository.findAll();
    }

    @PostConstruct
    public void init() {
        var cliente1 = new ClienteEntity("Gabriel","123456789");
        var cliente2 = new ClienteEntity("Anthony", "987654321");

        repository.save(cliente1);
        repository.save(cliente2);
    }

    public ClienteEntity criarCliente(ClienteEntity cliente) {
        var consultaCpf = repository.findClienteEntitiesByCpfIgnoreCase(cliente.getCpf());
        if (consultaCpf.isPresent()){
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        var consultaEmail = usuarioRepository.findUsuarioEntityByEmailIgnoreCase(cliente.getUsuario().getEmail());
        if (consultaEmail.isPresent()){
            throw new IllegalArgumentException("Email já cadastrado");
        }
        usuarioRepository.save(cliente.getUsuario());
        repository.save(cliente);
        return cliente;

    }
    public ClienteEntity atualizarCliente(long codigo, ClienteEntity clienteAtualizado) {
        var clienteExistenteOpt = repository.findById(codigo);
        if (clienteExistenteOpt.isEmpty()) {
            throw new IllegalArgumentException("Cliente com código " + codigo + " não encontrado");
        }

        var clienteExistente = clienteExistenteOpt.get();

        // Verificar se CPF está sendo alterado e se já existe no banco
        if (!clienteExistente.getCpf().equalsIgnoreCase(clienteAtualizado.getCpf())) {
            var cpfExistente = repository.findClienteEntitiesByCpfIgnoreCase(clienteAtualizado.getCpf());
            if (cpfExistente.isPresent()) {
                throw new IllegalArgumentException("CPF já cadastrado");
            }
            clienteExistente.setCpf(clienteAtualizado.getCpf());
        }

        // Atualizar nome (e outros campos que desejar)
        clienteExistente.setNome(clienteAtualizado.getNome());

        // Atualizar usuario, se necessário
        if (clienteAtualizado.getUsuario() != null) {
            var novoUsuario = clienteAtualizado.getUsuario();
            var usuarioExistente = clienteExistente.getUsuario();

            if (usuarioExistente == null || !usuarioExistente.getEmail().equalsIgnoreCase(novoUsuario.getEmail())) {
                // Verificar se email já existe
                var emailExistente = usuarioRepository.findUsuarioEntityByEmailIgnoreCase(novoUsuario.getEmail());
                if (emailExistente.isPresent()) {
                    throw new IllegalArgumentException("Email já cadastrado");
                }
                // Salvar novo usuário
                usuarioRepository.save(novoUsuario);
                clienteExistente.adicionarUsuario(novoUsuario);
            }
            // Se quiser atualizar a senha e admin, pode implementar aqui
        }

        return repository.save(clienteExistente);
    }

}
