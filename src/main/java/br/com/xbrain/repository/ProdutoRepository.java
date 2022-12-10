package br.com.xbrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xbrain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByDescricaoAndIdNot(String descricao, Long id);

    List<Produto> findAllByIdIn(List<Long> produtosIds);
    
}
