package br.com.xbrain.dto;

import br.com.xbrain.model.Produto;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProdutoRequest(
        @NotBlank
        String descricao,
        @Positive
        @Digits(fraction = 2, integer = 8) double valor) {

    public Produto toModel() {
        return Produto.builder()
                .descricao(descricao)
                .valor(valor)
                .build();
    }
}
