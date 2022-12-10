package br.com.xbrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xbrain.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>  {
    boolean existsByNome(String nome);
    
}
