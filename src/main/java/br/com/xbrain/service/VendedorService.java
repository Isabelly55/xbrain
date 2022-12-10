package br.com.xbrain.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.xbrain.exceptions.DuplicateException;
import br.com.xbrain.exceptions.NotFoundException;
import br.com.xbrain.model.Vendedor;
import br.com.xbrain.repository.VendedorRepository;

import java.util.List;
import java.util.Optional;

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

    public List<Vendedor>  buscarTodos(){
        return vendedorRepository.findAll();
    }

    private boolean existe(Vendedor vendedor) {
        return vendedorRepository.existsByNome(vendedor.getNome());
    }

}

