package br.com.xbrain.repository.impl;

import br.com.xbrain.dto.VendedorResponse;
import br.com.xbrain.repository.VendedorRepositoryQueryDsl;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static br.com.xbrain.model.QVendedor.vendedor;
import static br.com.xbrain.model.QVenda.venda;

@Repository
public class VendedorRepositoryImpl implements VendedorRepositoryQueryDsl {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VendedorResponse> buscarVendedor(LocalDate dataInicio, LocalDate dataFim) {
        double quantidadeDias = Period.between(dataInicio, dataFim).getDays();
        return new JPAQueryFactory(entityManager)
                .from(venda)
                .groupBy(vendedor.nome)
                .where(venda.dataVenda.between(dataInicio, dataFim))
                .select(Projections.constructor(VendedorResponse.class,
                        vendedor.nome, venda.id.count(), venda.valorTotal.sum(),
                        venda.valorTotal.sum().divide(quantidadeDias)))
                .join(venda.vendedor, vendedor)
                .fetch();
    }

}
