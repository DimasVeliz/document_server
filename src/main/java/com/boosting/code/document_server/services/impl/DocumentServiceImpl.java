package com.boosting.code.document_server.services.impl;

import com.boosting.code.document_server.dto.DocumentInfo;
import com.boosting.code.document_server.dto.DocumentInfoDto;
import com.boosting.code.document_server.services.IDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements IDocumentService {
    @Override
    public List<DocumentInfo> getDocuments() {
        return null;
    }

    @Override
    public DocumentInfoDto saveDocument(DocumentInfoDto documentInfo) {
        return null;
    }

    @Override
    public DocumentInfoDto getParticularDocumentInfo(String documentId) {
        return null;
    }
}
