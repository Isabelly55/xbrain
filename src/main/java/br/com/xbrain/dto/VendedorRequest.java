package br.com.xbrain.dto;

import br.com.xbrain.model.Vendedor;
import jakarta.validation.constraints.NotBlank;


public record VendedorRequest(
        @NotBlank
        String nome ){

    public Vendedor toModel() {
        return Vendedor.builder()
                .nome(nome)
                .build();
    }
}
