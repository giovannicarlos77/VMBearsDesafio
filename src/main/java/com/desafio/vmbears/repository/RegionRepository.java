package com.desafio.vmbears.repository;

import com.desafio.vmbears.entities.AgentModelEntity;
import com.desafio.vmbears.entities.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<RegionEntity, Long> {
    //SEARCH REGION BY SIGLA
    Optional<List<RegionEntity>> findBySigla(String sigla);
}
