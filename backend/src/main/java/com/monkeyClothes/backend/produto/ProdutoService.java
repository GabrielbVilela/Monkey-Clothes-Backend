package com.monkeyClothes.backend.produto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity salvar(ProdutoDTO dto) {
        ProdutoEntity produto = dto.toEntity();
        return produtoRepository.save(produto);
    }

    public List<ProdutoEntity> listarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoEntity buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    public ProdutoEntity atualizar(Long id, ProdutoDTO dto) {
        ProdutoEntity produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        produtoExistente.setNome(dto.getNome());
        produtoExistente.setDescricao(dto.getDescricao());
        produtoExistente.setPreco(dto.getPreco());
        produtoExistente.setEstoque(dto.getEstoque());
        produtoExistente.setUrlImagem(dto.getUrlImagem());

        return produtoRepository.save(produtoExistente);
    }
}
