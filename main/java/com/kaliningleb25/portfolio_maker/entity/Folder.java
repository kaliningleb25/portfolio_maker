package com.kaliningleb25.portfolio_maker.entity;

import javax.persistence.*;

@Entity
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private byte[] dataInBytes;
    private String userNickname;

    public Folder() {}

    public Folder(String name, byte[] dataInBytes, String userNickname) {
        this.name = name;
        this.dataInBytes = dataInBytes;
        this.userNickname = userNickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getDataInBytes() {
        return dataInBytes;
    }

    public void setDataInBytes(byte[] dataInBytes) {
        this.dataInBytes = dataInBytes;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
