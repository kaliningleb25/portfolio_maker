package com.kaliningleb25.portfolio_maker.entity;

import javax.persistence.*;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private byte[] dataInBytes;
    private Long folderId;

    public Picture() {}

    public Picture(byte[] dataInBytes, Long folderId) {
        this.dataInBytes = dataInBytes;
        this.folderId = folderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getDataInBytes() {
        return dataInBytes;
    }

    public void setDataInBytes(byte[] dataInBytes) {
        this.dataInBytes = dataInBytes;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }
}
