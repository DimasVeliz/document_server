package com.boosting.code.document_server.models;

public class FileInfo {
    private String mime;
    private byte[] data;

    public FileInfo(String mime, byte[] data) {
        this.mime = mime;
        this.data = data;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
