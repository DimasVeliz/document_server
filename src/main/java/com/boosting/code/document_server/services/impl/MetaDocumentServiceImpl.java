package com.boosting.code.document_server.services.impl;

import com.boosting.code.document_server.dto.MetaDocumentDisplayDto;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.MetaDocument;
import com.boosting.code.document_server.repositories.IMetaDocumentRepository;
import com.boosting.code.document_server.services.IMetaDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MetaDocumentServiceImpl implements IMetaDocumentService {

    private IMetaDocumentRepository repository;

    @Autowired
    public MetaDocumentServiceImpl(IMetaDocumentRepository repository) {
        this.repository = repository;
    }

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
                                   response.getOwner(),null);
    }

    @Override
    public List<MetaDocumentDisplayDto> getAllMetadocuments() {
        List<MetaDocument> metaDocuments = repository.findAll();
        if(metaDocuments.isEmpty()) return Collections.emptyList();

        return metaDocuments.stream().map(metaDoc -> new MetaDocumentDisplayDto(metaDoc.getName(),
                                                                        metaDoc.getYear(),
                                                                        metaDoc.getOwner(),
                                                                        metaDoc.getUuid()))
                                                                        .toList();
    }
}
