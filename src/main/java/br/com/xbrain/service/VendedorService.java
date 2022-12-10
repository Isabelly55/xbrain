package br.com.xbrain.service;


import br.com.xbrain.dto.VendedorResponse;
import br.com.xbrain.exceptions.DuplicateException;
import br.com.xbrain.exceptions.NotFoundException;
import br.com.xbrain.model.Vendedor;
import br.com.xbrain.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    @Transactional
    public Vendedor salvar(Vendedor vendedor) {
        if (!existe(vendedor)) return vendedorRepository.save(vendedor);
        else throw new DuplicateException("Já existe este vendedor cadastrado.");
    }

    public Vendedor buscarPorId(Long id) {
        return vendedorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Vendedor não encontrado")
        );
    }

    public List<VendedorResponse> buscarVendedor(LocalDate dataInicio, LocalDate dataFim){
        return vendedorRepository.buscarVendedor(dataInicio, dataFim);
    }

    private boolean existe(Vendedor vendedor) {
        return vendedorRepository.existsByNome(vendedor.getNome());
    }

}

