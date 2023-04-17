package com.boosting.code.document_server.services.impl;

import com.boosting.code.document_server.controller.DocumentController;
import com.boosting.code.document_server.dto.MetaDocumentDisplayDto;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfoDto;
import com.boosting.code.document_server.entities.FileInfo;
import com.boosting.code.document_server.entities.MetaDocument;
import com.boosting.code.document_server.services.IObjectStoreService;
import com.boosting.code.document_server.services.IFileInfoGeneralService;
import com.boosting.code.document_server.services.IMetaFileInfoService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileInfoGeneralServiceImpl implements IFileInfoGeneralService {

    Logger LOGGER = LogManager.getLogger(DocumentController.class);

    private final IMetaFileInfoService metaDocumentService;
    private final IObjectStoreService fileInfoService;

    @Override
    public ServiceInfoDto processDocumentInfo(MetaDocumentDto metaDocumentDto) {

        LOGGER.info("DocumentService received data to process: {}", metaDocumentDto);

        String uuid = String.valueOf(java.util.UUID.randomUUID());

        MetaDocument metaDocument = new MetaDocument(0,metaDocumentDto.getName(),
                                                          metaDocumentDto.getYear(),
                                                          metaDocumentDto.getOwner(),
                                                          uuid);

        ServiceInfo metaInfo = metaDocumentService.saveMetaDocument(metaDocument);

        FileInfo document = new FileInfo(metaDocument.getUuid(),
                                        metaDocumentDto.getFileInfo().getMime(),
                                        metaDocumentDto.getFileInfo().getData());

        ServiceInfo senderInfo = fileInfoService.sendDocument(document);

        boolean state = metaInfo.isSuccessful() && senderInfo.isSuccessful();

        ServiceInfoDto response= new ServiceInfoDto(state, new MetaDocumentDisplayDto(metaDocument.getName(),
                                                                                metaDocument.getYear(),
                                                                                metaDocument.getOwner(),
                                                                                metaDocument.getUuid()),
                                                    new ArrayList<>());

        response.getServicesInfo().add(metaInfo);
        response.getServicesInfo().add(senderInfo);

        LOGGER.info("DocumentService completed the processing, returning: {}", response);

        return response;

    }

    @Override
    public MetaDocumentDto processDownload(String uuid) {

        LOGGER.info("DocumentService received UUID: {} to download document", uuid);


        MetaDocumentDto metaInfo = metaDocumentService.getMetaDocument(uuid);
        if(null == metaInfo){
            return null;
        }

        FileInfo document = fileInfoService.getDocument(uuid);

        metaInfo.setFileInfo(new com.boosting.code.document_server.models.FileInfo(document.getMime(), document.getData()));

        LOGGER.info("DocumentService completed the processing, returning: {}", metaInfo);

        return metaInfo;
    }

    @Override
    public List<MetaDocumentDisplayDto> getDocumentsMetaData() {

        List<MetaDocumentDisplayDto> metaDocuments = metaDocumentService.getAllMetadocuments();

        return metaDocuments;
    }
}
