package com.boosting.code.document_server.services;

import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfoDto;

public interface IDocumentService {

    ServiceInfoDto processDocumentInfo(MetaDocumentDto metaDocumentDto);
}
