package com.boosting.code.document_server.services.impl;

import com.boosting.code.document_server.controller.DocumentController;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfoDto;
import com.boosting.code.document_server.entities.Document;
import com.boosting.code.document_server.entities.MetaDocument;
import com.boosting.code.document_server.services.IDocumentSenderService;
import com.boosting.code.document_server.services.IDocumentService;
import com.boosting.code.document_server.services.IMetaDocumentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DocumentServiceImpl implements IDocumentService {

    Logger LOGGER = LogManager.getLogger(DocumentController.class);

    IMetaDocumentService metaDocumentService;
    IDocumentSenderService documentSenderService;

    public DocumentServiceImpl(IMetaDocumentService metaDocumentService, IDocumentSenderService documentSenderService) {
        this.metaDocumentService = metaDocumentService;
        this.documentSenderService = documentSenderService;
    }

    @Override
    public ServiceInfoDto processDocumentInfo(MetaDocumentDto metaDocumentDto) {

        LOGGER.info("DocumentService received data to process: {}", metaDocumentDto);
        String uuid = String.valueOf(java.util.UUID.randomUUID());

        MetaDocument metaDocument = new MetaDocument(0,metaDocumentDto.getName(),
                                                          metaDocumentDto.getYear(),
                                                          metaDocumentDto.getOwner(),
                                                          uuid);

        ServiceInfo metaInfo = metaDocumentService.saveMetaDocument(metaDocument);

        Document document = new Document(metaDocument.getUuid(),
                                        metaDocumentDto.getFileInfo().getMime(),
                                        metaDocumentDto.getFileInfo().getData());

        ServiceInfo senderInfo =documentSenderService.sendDocument(document);

        boolean state = metaInfo.isSuccessfull() && senderInfo.isSuccessfull();

        ServiceInfoDto response= new ServiceInfoDto(state, new MetaDocumentDto(metaDocument.getName(),
                                                                                metaDocument.getYear(),
                                                                                metaDocument.getOwner(),
                                                                                null),
                                                    new ArrayList<>());

        response.getServicesInfo().add(metaInfo);
        response.getServicesInfo().add(senderInfo);

        LOGGER.info("DocumentService completed the processing, returning: {}", response);

        return response;

    }
}
