package com.boosting.code.document_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInfoDto {

    private boolean isSuccessfull;

    MetaDocumentDisplayDto metadata;

    List<ServiceInfo> servicesInfo;
}
