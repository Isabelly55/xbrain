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

import br.com.xbrain.dto.VendaRequest;
import br.com.xbrain.model.Venda;
import br.com.xbrain.service.VendaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/venda")
@AllArgsConstructor
public class VendaController {
    private final VendaService vendaService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Venda salvar(@Valid @RequestBody VendaRequest venda) {
        return vendaService.salvar(venda.toModel());
    }

    @GetMapping("/{id}")
    public Venda buscarPorId(@PathVariable Long id) {
        return vendaService.buscarPorId(id);
    }

    @GetMapping
    public List<Venda> venda() {
        return vendaService.buscarTodos();
    }

}
