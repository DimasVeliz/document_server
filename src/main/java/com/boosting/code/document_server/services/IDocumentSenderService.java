package com.boosting.code.document_server.services;

import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.Document;

public interface IDocumentSenderService {
    ServiceInfo sendDocument(Document document);

    Document getDocument(String uuid);
}
