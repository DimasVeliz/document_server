package com.boosting.code.document_server.dto;

public class DocumentInfo {

    private String id;
    private String name;
    private String year;
    private byte[] data;

    public DocumentInfo(String id, String name, String year, byte[] data) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
