package com.desafio.vmbears.controller;

import com.desafio.vmbears.request.RegionRequest;
import com.desafio.vmbears.service.ProcessXmlFileService;
import com.desafio.vmbears.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
public class ApiController
{
    @Autowired
    private ProcessXmlFileService processXmlFileService;

    @Autowired
    private RegionService regionService;

    @PostMapping(value = "/process-xml", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void receiveFile(@RequestParam("file") List<MultipartFile> files) throws Exception {
        for (MultipartFile file : files) {
            var xmlObject = processXmlFileService.proccessXmlData(file);
            processXmlFileService.printAgentCodeFromList(xmlObject);
        }
    }

    @PostMapping(value = "/find-region", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findBySigla(@RequestBody RegionRequest regionRequest) {
        var region = regionService.findBySigla(regionRequest.getSigla());
        return ResponseEntity.ok(region);
    }
}
