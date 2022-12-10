package br.com.xbrain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.xbrain.dto.ProdutoRequest;
import br.com.xbrain.model.Produto;
import br.com.xbrain.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto salvar(@Valid @RequestBody ProdutoRequest produto) {
        return produtoService.salvar(produto.toModel());
    }

    @GetMapping
    public List<Produto> produtos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }
}
