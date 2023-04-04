package com.boosting.code.document_server.entities;


import jakarta.persistence.*;

@Entity
@Table(name="metadocument")
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
    private String owner;
    @Column
    private String uuid;

    public MetaDocument(int id, String name, String year,String owner, String uuid) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.owner = owner;
        this.uuid = uuid;
    }

    public MetaDocument() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
