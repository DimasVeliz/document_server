package com.boosting.code.document_server.controller;


import com.boosting.code.document_server.dto.MetaDocumentDisplayDto;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfoDto;
import com.boosting.code.document_server.services.IFileInfoGeneralService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cloud")
@RequiredArgsConstructor
public class DocumentController {


    Logger LOGGER = LogManager.getLogger(DocumentController.class);
    private final IFileInfoGeneralService documentService;

    @GetMapping("/metadocuments")
    public ResponseEntity<List<MetaDocumentDisplayDto>> getListOfMetadata()
    {
        LOGGER.info("Attempting to get all the Metadata from Documents");

        List<MetaDocumentDisplayDto> metadataResponse =documentService.getDocumentsMetaData();

        LOGGER.info("Successfully got all the Metadata from Documents: {}",metadataResponse);


        return new ResponseEntity<>(metadataResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceInfoDto> postDocument(@RequestBody MetaDocumentDto metaDocumentDto){

        LOGGER.info("Attempting to save a Document with name: {}",metaDocumentDto.getName());

        ServiceInfoDto infoResponse =documentService.processDocumentInfo(metaDocumentDto);

        LOGGER.info("Successfully saved a Document, response: {}",infoResponse);


        return new ResponseEntity<>(infoResponse, HttpStatus.OK);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadSpecificDocument(@RequestParam String documentUUID){
        LOGGER.info("Attempting to download a Document with uuid: {}", documentUUID);

        MetaDocumentDto metaDocumentDto =documentService.processDownload(documentUUID);

        if(null==metaDocumentDto) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        HttpHeaders headers = makeHeaders(metaDocumentDto);
        LOGGER.info("Successfully downloaded a Document with uuid: {}", documentUUID);

        return new ResponseEntity<>(metaDocumentDto.getFileInfo().getData(),headers, HttpStatus.OK);
    }

    private HttpHeaders makeHeaders(MetaDocumentDto metaDocumentDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition","filename=\""+metaDocumentDto.getName()+"\"");
        headers.set("Content-Type",metaDocumentDto.getFileInfo().getMime());

        return headers;

    }
}
