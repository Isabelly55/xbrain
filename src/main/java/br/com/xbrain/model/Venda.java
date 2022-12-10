package br.com.xbrain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venda")
public class Venda  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private LocalDate dataVenda;

    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0", nullable = false)
    private double valorTotal;

    @ManyToOne(targetEntity = Vendedor.class)
    @JoinColumn(name = "vendedor", foreignKey = @ForeignKey(name = "fk_pedido_vendedor"))
    private Vendedor vendedor;

    @ManyToMany(targetEntity = Produto.class)
    @JoinTable(name = "venda_produtos",
            joinColumns = @JoinColumn(name = "venda_id", foreignKey = @ForeignKey(name = "fk_venda_id")),
            inverseJoinColumns = @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name = "fk_venda_produto")))
    private List<Produto> produtos;

}

