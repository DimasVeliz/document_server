package com.boosting.code.document_server.dto;

public class ServiceInfo {
    private boolean isSuccessfull;
    private String message;


    public ServiceInfo(boolean isSuccessfull, String message) {
        this.message = message;
        this.isSuccessfull=isSuccessfull;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public void setSuccessfull(boolean successfull) {
        isSuccessfull = successfull;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
