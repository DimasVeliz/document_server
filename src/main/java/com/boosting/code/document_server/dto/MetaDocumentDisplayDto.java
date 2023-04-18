package com.boosting.code.document_server.dto;

import com.boosting.code.document_server.models.FileInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaDocumentDisplayDto {
    private String name;
    private String year;
    private String ownerUuid;
    private String uuid;

}
