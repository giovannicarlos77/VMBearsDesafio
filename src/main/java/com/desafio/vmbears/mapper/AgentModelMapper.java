package com.desafio.vmbears.mapper;

import com.desafio.vmbears.entities.AgentModelEntity;
import com.desafio.vmbears.model.AgentModel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AgentModelMapper {

    private final ObjectMapper objectMapper;

    public AgentModelMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public AgentModelEntity mapToEntity(AgentModel agentModel) {
        return objectMapper.convertValue(agentModel, AgentModelEntity.class);
    }
}