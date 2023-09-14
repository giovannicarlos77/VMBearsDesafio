package com.desafio.vmbears.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agent_model")
@Data
public class AgentModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_model_id")
    private List<AgentEntity> agentes;

}