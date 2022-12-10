package br.com.xbrain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vendedor", uniqueConstraints = @UniqueConstraint(name = "uc_vendedor", columnNames = "nome"))
public class Vendedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false,length = 80)
    private String nome;

    public Vendedor(Long id) {
        this.id = id;
    }
    
}
