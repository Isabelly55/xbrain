package br.com.xbrain.controller;

import br.com.xbrain.dto.VendedorRequest;
import br.com.xbrain.dto.VendedorResponse;
import br.com.xbrain.model.Vendedor;
import br.com.xbrain.service.VendedorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public List<VendedorResponse> buscarVendedor(@RequestParam  LocalDate dataInicio, @RequestParam LocalDate dataFim) {
        return vendedorService.buscarVendedor(dataInicio, dataFim);
    }
    
}
