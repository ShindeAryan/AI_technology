package com.example.AI_technology.career;

import jakarta.persistence.*;

@Entity
public class Resume {
    @Id
    private long id;
    @Column(name = "fileType")
    private String fileType;
    @Lob
    private byte[] data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
