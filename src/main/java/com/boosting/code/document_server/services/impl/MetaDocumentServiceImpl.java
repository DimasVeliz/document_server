package com.boosting.code.document_server.services.impl;

import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.MetaDocument;
import com.boosting.code.document_server.repositories.IMetaDocumentRepository;
import com.boosting.code.document_server.services.IMetaDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
