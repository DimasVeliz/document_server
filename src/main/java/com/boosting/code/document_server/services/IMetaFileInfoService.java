package com.boosting.code.document_server.services;

import com.boosting.code.document_server.dto.MetaDocumentDisplayDto;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.MetaDocument;

import java.util.List;

public interface IMetaFileInfoService {

    ServiceInfo saveMetaDocument(MetaDocument metaDocument);

    MetaDocumentDto getMetaDocument(String uuid);

    List<MetaDocumentDisplayDto> getAllMetadocuments(String ownerUuid);
}
