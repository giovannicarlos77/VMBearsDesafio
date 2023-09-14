package com.desafio.vmbears.service;

import com.desafio.vmbears.entities.AgentModelEntity;
import com.desafio.vmbears.mapper.AgentModelMapper;
import com.desafio.vmbears.model.AgentModel;
import com.desafio.vmbears.repository.AgentModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class AgentService {
    @Autowired
    private AgentModelRepository agentModelRepository;

    private final AgentModelMapper objectMapper;

    public AgentService(AgentModelMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public AgentModelEntity convertAgentModelAndSave(AgentModel agentModel) {
        var agentModelEntity = objectMapper.mapToEntity(agentModel);
        return agentModelRepository.save(agentModelEntity);
    }

    public AgentModelEntity createAgentModel(AgentModelEntity agentModelEntity) {
        return agentModelRepository.save(agentModelEntity);
    }
}
