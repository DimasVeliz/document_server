package com.boosting.code.document_server.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="metadocument")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaDocument {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name="id")
    private int id;
    @Column
    private String name;
    @Column
    private String year;
    @Column
    private String ownerUuid;
    @Column
    private String uuid;


}
