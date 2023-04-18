package com.boosting.code.document_server.services.impl;

import com.boosting.code.document_server.dto.MetaDocumentDisplayDto;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.MetaDocument;
import com.boosting.code.document_server.repositories.IMetaDocumentRepository;
import com.boosting.code.document_server.services.IMetaFileInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MetaFileInfoServiceImpl implements IMetaFileInfoService {

    private final IMetaDocumentRepository repository;

    @Override
    public ServiceInfo saveMetaDocument(MetaDocument metaDocument) {

        MetaDocument response =repository.save(metaDocument);
        if(null == response){
            return new ServiceInfo(false,"Metadata could not be inserted into the DB");

        }
        return new ServiceInfo(true,"Metadata Successfully inserted into the DB");
    }

    @Override
    public MetaDocumentDto getMetaDocument(String uuid) {
        MetaDocument response =repository.findByUuid(uuid);
        if(null == response){
            return null;

        }
        return new MetaDocumentDto(response.getName(),
                                   response.getYear(),
                                   response.getOwnerUuid(),null);
    }

    @Override
    public List<MetaDocumentDisplayDto> getAllMetadocuments(String ownerUuid) {
        List<MetaDocument> metaDocuments = repository.findByOwnerUuid(ownerUuid);
        if(metaDocuments.isEmpty()) return Collections.emptyList();

        return metaDocuments.stream().map(metaDoc -> new MetaDocumentDisplayDto(metaDoc.getName(),
                                                                        metaDoc.getYear(),
                                                                        metaDoc.getOwnerUuid(),
                                                                        metaDoc.getUuid()))
                                                                        .toList();
    }
}
