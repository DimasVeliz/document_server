package com.boosting.code.document_server.dto;

import com.boosting.code.document_server.models.FileInfo;

public class MetaDocumentDto {
    private String name;
    private String year;
    private String owner;
    private FileInfo fileInfo;

    public MetaDocumentDto(String name, String year, String owner, FileInfo fileInfo) {
        this.name = name;
        this.year = year;
        this.owner = owner;
        this.fileInfo = fileInfo;
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

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }
}
