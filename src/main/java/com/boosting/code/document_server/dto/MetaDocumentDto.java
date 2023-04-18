package com.boosting.code.document_server.dto;

import com.boosting.code.document_server.models.FileInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MetaDocumentDto {
    private String name;
    private String year;
    private String ownerUuid;
    private FileInfo fileInfo;
}
