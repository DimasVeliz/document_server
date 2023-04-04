package com.boosting.code.document_server.webcomponents;

import com.boosting.code.document_server.constants.Constants;
import org.hibernate.annotations.Comment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebConfig {
    public WebClient getBinaryClient() {
        WebClient client = WebClient.builder()
                .baseUrl(Constants.OBJECT_STORE_HOST)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .build();

        return client;
    }

    public WebClient getJSONClient() {
        WebClient client = WebClient.builder()
                .baseUrl(Constants.OBJECT_STORE_HOST)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        return client;
    }
}
