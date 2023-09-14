package com.desafio.vmbears.service;

import com.desafio.vmbears.entities.RegionEntity;
import com.desafio.vmbears.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<RegionEntity> findBySigla(String acronym) {
        var regionEntityList = regionRepository.findBySigla(acronym);
        if (regionEntityList.isPresent()) {
            List<RegionEntity> regionList = regionEntityList.get();
            for (RegionEntity region : regionList) {
                region.setPrecoMedio(new ArrayList<>());
            }
        }
        return regionEntityList.orElse(null);
    }
}
