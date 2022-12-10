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

import br.com.xbrain.dto.VendedorRequest;
import br.com.xbrain.model.Vendedor;
import br.com.xbrain.service.VendedorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vendedor")
@AllArgsConstructor
public class VendedorController {
    private final VendedorService vendedorService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vendedor salvar(@Valid @RequestBody VendedorRequest vendedor) {
        return vendedorService.salvar(vendedor.toModel());
    }

    @GetMapping("/{id}")
    public Vendedor buscarPorId(@PathVariable Long id) {
        return vendedorService.buscarPorId(id);
    }

    @GetMapping
    public List<Vendedor> vendedores() {
        return vendedorService.buscarTodos();
    }
    
}
