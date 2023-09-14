package com.desafio.vmbears.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegionRequest {
    @JsonProperty("sigla")
    private String sigla;

}
