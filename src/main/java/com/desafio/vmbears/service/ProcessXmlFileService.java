package com.desafio.vmbears.service;
import com.desafio.vmbears.model.AgentModel;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProcessXmlFileService {

    @Autowired
    private XmlMapper xmlMapper;

    @Autowired
    private AgentService agentService;

    public AgentModel proccessXmlData(MultipartFile file) throws Exception {
        try {
            AgentModel xmlObject = xmlMapper.readValue(file.getInputStream(), AgentModel.class);
            agentService.convertAgentModelAndSave(xmlObject);
            return xmlObject;
        }catch (Exception e){
            System.out.println("Error processing XML file: " + e.getMessage());
            throw e;
        }
    }

    public void printAgentCodeFromList(AgentModel agentModel){
        var agentList = agentModel.getAgentes();
        for (AgentModel.Agente agent : agentList){
            System.out.println(agent.getCodigo());
        }
    }
}
