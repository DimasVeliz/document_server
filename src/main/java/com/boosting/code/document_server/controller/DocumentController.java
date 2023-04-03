package com.boosting.code.document_server.controller;


import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfoDto;
import com.boosting.code.document_server.services.IDocumentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {


    Logger LOGGER = LogManager.getLogger(DocumentController.class);
    private IDocumentService documentService;

    @Autowired
    public DocumentController(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<ServiceInfoDto> postDocument(@RequestBody MetaDocumentDto metaDocumentDto){

        LOGGER.info("Attempting to save a Document with name: {}",metaDocumentDto.getName());

        ServiceInfoDto infoResponse =documentService.processDocumentInfo(metaDocumentDto);

        return new ResponseEntity<>(infoResponse, HttpStatus.OK);
    }
}
