package br.com.xbrain.repository;

import java.time.LocalDate;
import java.util.List;

import br.com.xbrain.dto.VendedorResponse;

public interface VendedorRepositoryQueryDsl {
    List<VendedorResponse> buscarVendedor(LocalDate dataInicio, LocalDate dataFim);
}
