package com.boosting.code.document_server.services.impl;

import com.boosting.code.document_server.constants.Constants;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.Document;
import com.boosting.code.document_server.services.IDocumentSenderService;
import com.boosting.code.document_server.webcomponents.WebConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.image.DataBuffer;
import java.util.Optional;

@Service
public class DocumentSenderServiceImpl implements IDocumentSenderService {

    private WebConfig webConfig;

    public DocumentSenderServiceImpl(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    @Override
    public ServiceInfo sendDocument(Document document) {

        WebClient.ResponseSpec responseSpec = webConfig.getJSONClient()
                .post().uri(Constants.DOCUMENTS_URI)
                .body(Mono.just(document),Document.class)
                .retrieve();

        ServiceInfo response = responseSpec.bodyToMono(ServiceInfo.class).block();

        if(null == response)
        {
            return new ServiceInfo(false,"failed to post the document to the object store");
        }
        return response;
    }

    @Override
    public Document getDocument(String uuid) {
        Optional<String> uuidEntity = Optional.ofNullable(uuid);
        WebClient.ResponseSpec responseSpec = webConfig.getBinaryClient()
                .get().uri(Constants.DOCUMENTS_DOWNLOAD_URI, uriBuilder ->
                   uriBuilder.queryParamIfPresent("documentUUID",uuidEntity).build()
                )
                .retrieve();

        Document response = responseSpec.bodyToMono(Document.class).block();

        if(null == response)
        {
            return null;
        }
        return response;
    }
}
