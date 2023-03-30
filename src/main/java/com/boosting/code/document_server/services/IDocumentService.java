package com.boosting.code.document_server.services;

import com.boosting.code.document_server.dto.DocumentInfo;
import com.boosting.code.document_server.dto.DocumentInfoDto;

import java.util.List;

public interface IDocumentService {
    List<DocumentInfo> getDocuments();

    DocumentInfoDto saveDocument(DocumentInfoDto documentInfo);

    DocumentInfoDto getParticularDocumentInfo(String documentId);
}
