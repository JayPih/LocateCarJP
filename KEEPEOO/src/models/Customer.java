package models;

import enums.TypeDocument;

public class Customer {
    public Customer(String id, String name, String document, TypeDocument typeDocument) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.typeDocument = typeDocument;
    }

    private String id;
    private String name;
    private String document;
    private TypeDocument typeDocument;

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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }
}
