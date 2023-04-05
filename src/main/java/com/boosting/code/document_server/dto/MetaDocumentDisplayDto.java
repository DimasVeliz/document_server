package com.boosting.code.document_server.dto;

import com.boosting.code.document_server.models.FileInfo;

public class MetaDocumentDisplayDto {
    private String name;
    private String year;
    private String owner;
    private String uuid;

    public MetaDocumentDisplayDto(String name, String year, String owner, String uuid) {
        this.name = name;
        this.year = year;
        this.owner = owner;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
