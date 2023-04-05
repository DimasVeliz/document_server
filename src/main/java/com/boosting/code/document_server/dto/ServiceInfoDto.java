package com.boosting.code.document_server.dto;

import java.util.List;

public class ServiceInfoDto {

    private boolean isSuccessfull;

    MetaDocumentDisplayDto metadata;

    List<ServiceInfo> servicesInfo;

    public ServiceInfoDto(boolean isSuccessfull, MetaDocumentDisplayDto metadata,List<ServiceInfo> servicesInfo) {
        this.isSuccessfull = isSuccessfull;
        this.metadata = metadata;
        this.servicesInfo = servicesInfo;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public void setSuccessfull(boolean successfull) {
        isSuccessfull = successfull;
    }

    public MetaDocumentDisplayDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaDocumentDisplayDto metadata) {
        this.metadata = metadata;
    }

    public List<ServiceInfo> getServicesInfo() {
        return servicesInfo;
    }

    public void setServicesInfo(List<ServiceInfo> servicesInfo) {
        this.servicesInfo = servicesInfo;
    }
}
