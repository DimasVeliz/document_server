package com.boosting.code.document_server.services;

import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.MetaDocument;

public interface IMetaDocumentService {

    ServiceInfo saveMetaDocument(MetaDocument metaDocument);

    MetaDocumentDto getMetaDocument(String uuid);
}
