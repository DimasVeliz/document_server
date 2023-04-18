package com.boosting.code.document_server.repositories;

import com.boosting.code.document_server.entities.MetaDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMetaDocumentRepository extends JpaRepository<MetaDocument, Integer> {

    MetaDocument findByUuid(String uuid);
    List<MetaDocument> findByOwnerUuid(String ownerUuid);
}
