package com.boosting.code.document_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInfo {
    private boolean isSuccessful;
    private String message;
}
