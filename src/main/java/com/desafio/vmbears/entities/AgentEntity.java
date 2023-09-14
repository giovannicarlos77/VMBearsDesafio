package com.desafio.vmbears.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agent")
@Data
public class AgentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "data")
    private String data;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agente_id")
    private List<RegionEntity> regiao;
}