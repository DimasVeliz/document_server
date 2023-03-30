package com.boosting.code.document_server.controller;


import com.boosting.code.document_server.dto.DocumentInfo;
import com.boosting.code.document_server.dto.DocumentInfoDto;
import com.boosting.code.document_server.exceptions.DocumentException;
import com.boosting.code.document_server.services.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

@RestController
public class DocumentController {


    Logger LOGGER = LogManager.getLogger(DocumentController.class);
    private IDocumentService service;

    @Autowired
    public DocumentController(IDocumentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DocumentInfo>> getDocumentsInfo(){
        LOGGER.info("List of all documents required");

        List<DocumentInfo> documentsInfo = service.getDocuments();
        if(null==documentsInfo || documentsInfo.size()==0)
        {
            LOGGER.error("DocumentInfo list is null or empty");
            throw new DocumentException("could not get the list of documents");
        }
        return new ResponseEntity<>(documentsInfo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DocumentInfoDto> getParticularDocumentInfo(@RequestParam String documentId){
        LOGGER.info("List of all documents required");

        DocumentInfoDto documentsInfo = service.getParticularDocumentInfo(documentId);
        if(null==documentsInfo )
        {
            LOGGER.error("DocumentInfo was is null or empty, not found");
            throw new DocumentException("could not get the document info");
        }
        return new ResponseEntity<>(documentsInfo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DocumentInfoDto> postDocument(@RequestBody DocumentInfoDto documentInfo){
        LOGGER.info("Attempting to save a Document with name: {}",documentInfo.getName());

        DocumentInfoDto documentInfoResponse = service.saveDocument(documentInfo);
        if(null==documentInfoResponse )
        {
            LOGGER.error("DocumentInfo was null, could not save the document");
            throw new DocumentException("could not get the requested document");
        }
        return new ResponseEntity<>(documentInfoResponse, HttpStatus.OK);
    }
}
