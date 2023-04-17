package com.boosting.code.document_server.services;

import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.FileInfo;

public interface IObjectStoreService {
    ServiceInfo sendDocument(FileInfo document);

    FileInfo getDocument(String uuid);
}
