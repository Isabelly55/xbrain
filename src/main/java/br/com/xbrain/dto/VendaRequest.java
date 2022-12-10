package br.com.xbrain.dto;

import java.util.List;

import br.com.xbrain.model.Produto;
import br.com.xbrain.model.Venda;
import br.com.xbrain.model.Vendedor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

public record VendaRequest(
    @NotNull
    Long vendedorId,
    @NotEmpty
    List<Long> produtosIds ) {

    public Venda toModel() {
        return Venda.builder()
                .vendedor(new Vendedor(vendedorId))
                .produtos(produtosIds.stream().map(Produto::new).toList())
                .build();
    }
}

