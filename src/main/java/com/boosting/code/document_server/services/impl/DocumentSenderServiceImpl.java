package com.boosting.code.document_server.services.impl;

import com.boosting.code.document_server.constants.Constants;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.Document;
import com.boosting.code.document_server.services.IDocumentSenderService;
import com.boosting.code.document_server.webcomponents.WebConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.awt.image.DataBuffer;

@Service
public class DocumentSenderServiceImpl implements IDocumentSenderService {

    WebConfig webConfig;
    @Override
    public ServiceInfo sendDocument(Document document) {

        WebClient.ResponseSpec responseSpec = webConfig.getBinaryClient()
                .post().uri(Constants.DOCUMENTS_URI)
                .body(makeFlux(document),DataBuffer.class)
                .retrieve();

        if(null == responseSpec)
        {
            return new ServiceInfo(false,"failed to post the document to the object store");
        }
        return new ServiceInfo(true,"Successfully posted the document to the object store");
    }

    private Flux<Document> makeFlux(Document document) {
        return Flux.just(document);
    }
}
