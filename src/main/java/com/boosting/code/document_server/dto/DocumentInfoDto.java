package com.boosting.code.document_server.dto;

public class DocumentInfoDto {

    private String name;
    private String year;
    private byte[] data;

    public DocumentInfoDto(String name, String year, byte[] data) {
        this.name = name;
        this.year = year;
        this.data = data;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
