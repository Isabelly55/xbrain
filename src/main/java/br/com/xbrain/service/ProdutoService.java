package br.com.xbrain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.xbrain.exceptions.DuplicateException;
import br.com.xbrain.exceptions.NotFoundException;
import br.com.xbrain.model.Produto;
import br.com.xbrain.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto) {
        if (!existe(produto)) return produtoRepository.save(produto);
        else throw new DuplicateException("Já existe este produto cadastrado.");
    }

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Produto não encontrado")
        );
    }

    private boolean existe(Produto produto) {
        return produtoRepository.existsByDescricao(produto.getDescricao());
    }

}
