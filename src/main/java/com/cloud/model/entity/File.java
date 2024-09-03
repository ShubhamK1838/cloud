package com.cloud.model.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    private String name;
    private String size;
    private String type ;
    @Temporal(TemporalType.DATE)
    @Column(name="uploaded_date")
    private Date uploadedDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Transient
    private MultipartFile part;


    public File()
    {

    }
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MultipartFile getPart() {
        return part;
    }

    public void setPart(MultipartFile part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "File{" +
                "fid=" + fid +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", uploadedDate=" + uploadedDate +
                ", user=" + user.getName()+" id " + user.getId() +
                '}';
    }
}
