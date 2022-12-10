package br.com.xbrain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.xbrain.exceptions.NotFoundException;
import br.com.xbrain.model.Produto;
import br.com.xbrain.model.Venda;
import br.com.xbrain.repository.ProdutoRepository;
import br.com.xbrain.repository.VendaRepository;
import br.com.xbrain.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VendaService {
    private final VendaRepository vendaRepository;
    private final VendedorRepository vendedorRepository;
    private final ProdutoRepository produtoRepository;

    @Transactional
    public Venda salvar(Venda venda)  {
        setDadosVenda(venda);
        return vendaRepository.save(venda);
    }
    
    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id).orElseThrow(() -> new NotFoundException("Venda não encontrada"));
    }

    public List<Venda> buscarTodos(){
        return vendaRepository.findAll();
    }

    private void setDadosVenda(Venda venda) {
        var vendedor = vendedorRepository.findById(venda.getVendedor().getId())
                .orElseThrow(() -> new NotFoundException("Vendedor não encontrado"));

        venda.setVendedor(vendedor);
        
        var produtos = produtoRepository.findAllByIdIn(venda.getProdutos().stream().map(Produto::getId).toList());

        if (produtos.isEmpty()) {
            throw new NotFoundException("Produtos não encontrados");
        }

        venda.setProdutos(produtos);
        venda.setValorTotal(produtos.stream().mapToDouble(Produto::getValor).sum());
    }
}
