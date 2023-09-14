package com.desafio.vmbears.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "agentes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentModel {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "agente")
    private List<Agente> agentes;

    @Data
    public static class Agente {
        private String codigo;
        private String data;
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "regiao")
        private List<Regiao> regiao;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Regiao {
        @JacksonXmlProperty(isAttribute = true)
        private String sigla;

        @JacksonXmlElementWrapper(localName = "geracao")
        @JsonAlias("valor")
        private List<Double> geracao;

        @JacksonXmlElementWrapper(localName = "compra")
        @JsonAlias("valor")
        private List<Double> compra;

        @JacksonXmlElementWrapper(localName = "precoMedio")
        @JsonAlias("valor")
        private List<Double> precoMedio;
    }
}