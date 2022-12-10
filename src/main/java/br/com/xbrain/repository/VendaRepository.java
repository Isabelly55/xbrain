package br.com.xbrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xbrain.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}
