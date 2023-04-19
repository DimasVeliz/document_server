package com.boosting.code.document_server.services;

import com.boosting.code.document_server.dto.MetaDocumentDisplayDto;
import com.boosting.code.document_server.dto.MetaDocumentDto;
import com.boosting.code.document_server.dto.ServiceInfoDto;

import java.util.List;

public interface IFileInfoGeneralService {

    ServiceInfoDto processDocumentInfo(MetaDocumentDto metaDocumentDto);

    MetaDocumentDto processDownload(String uuid, String ownerUuid);

    List<MetaDocumentDisplayDto> getDocumentsMetaData(String ownerUuid);
}
