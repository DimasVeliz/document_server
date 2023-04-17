package com.boosting.code.document_server.services.impl;

import com.boosting.code.Config.WebConfig;
import com.boosting.code.Dto.ProtoRequest;
import com.boosting.code.Dto.ProxyResponseDto;
import com.boosting.code.Services.IProxyService;
import com.boosting.code.document_server.constants.Constants;
import com.boosting.code.document_server.dto.ServiceInfo;
import com.boosting.code.document_server.entities.FileInfo;
import com.boosting.code.document_server.services.IObjectStoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObjectStoreServiceImpl implements IObjectStoreService {

    private final IProxyService proxyService;

    private final ObjectMapper mapper;

    @Override
    public ServiceInfo sendDocument(FileInfo document) {

        String stringifiedDoc= formatBody(document);
        ProtoRequest protoRequest = ProtoRequest
                .builder()
                .isBinaryClient(false)
                .baseURL(Constants.OBJECT_STORE_HOST)
                .queryString(null)
                .body(stringifiedDoc)
                .uri(Constants.DOCUMENTS_URI)
                .build();
        ProxyResponseDto proxyResponseDto = proxyService
                                                .processRequestGivenResources(protoRequest,
                                                                             "POST");

       ServiceInfo response = serializeResponse(proxyResponseDto.getJsonData(),ServiceInfo.class);

        if(null == response)
        {
            return new ServiceInfo(false,"failed to post the document to the object store");
        }
        return response;
    }



    @Override
    public FileInfo getDocument(String uuid) {

        ProtoRequest protoRequest = ProtoRequest
                .builder()
                .isBinaryClient(false)
                .baseURL(Constants.OBJECT_STORE_HOST)
                .queryString("documentUUID=".concat(uuid))
                .body(null)
                .uri(Constants.DOCUMENTS_DOWNLOAD_URI)
                .build();

        ProxyResponseDto proxyResponseDto = proxyService
                .processRequestGivenResources(protoRequest,
                        "GET");

        FileInfo response = serializeResponse(proxyResponseDto.getJsonData(), FileInfo.class);

        return response;
    }

    private <T> T serializeResponse(JsonNode jsonData, Class<T> givenType) {
        return mapper.convertValue(jsonData,givenType);
    }

    private String formatBody(FileInfo document) {
        String body;
        try {
            body = mapper.writeValueAsString(document);
        } catch (JsonProcessingException e) {
            body="";
        }
        return body;
    }
}
