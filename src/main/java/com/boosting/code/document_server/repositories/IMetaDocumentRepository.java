package com.boosting.code.document_server.repositories;

import com.boosting.code.document_server.entities.MetaDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMetaDocumentRepository extends JpaRepository<MetaDocument, Integer> {
}
