package com.cloud.model.entity;


import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name="user_name")
    private String name;
    private String password;
    private String email;
    @Column(name="image_name")
    private String imageName;
    @Transient
    private byte[] imageData;

    @Transient
    private  MultipartFile part;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user",cascade = CascadeType.ALL)
    private List<File> fileList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name ) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String  getImageName() {
        return imageName;
    }

    public void setImageName(String image ) {
        this.imageName=image;
    }

    public void setFile(MultipartFile part )
    {
        this.part=part;
        if(part!=null)
        {
            setImageName(part.getOriginalFilename());
        }
    }
    public MultipartFile getFile()
    {
        return part; 
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
    public byte[] getImageData() {
        return imageData;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", imageId=" + imageName +
                '}';
    }
}
