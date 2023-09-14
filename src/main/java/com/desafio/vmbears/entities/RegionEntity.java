package com.desafio.vmbears.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "regiao")
@Data
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sigla")
    private String sigla;

    @ElementCollection
    @CollectionTable(name = "geracao", joinColumns = @JoinColumn(name = "regiao_id"))
    private List<Double> geracao;

    @ElementCollection
    @CollectionTable(name = "compra", joinColumns = @JoinColumn(name = "regiao_id"))
    private List<Double> compra;

    @ElementCollection
    @CollectionTable(name = "preco_medio", joinColumns = @JoinColumn(name = "regiao_id"))
    private List<Double> precoMedio;
}
