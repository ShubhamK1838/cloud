package com.cloud.model.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageService {
    
    private String DIR=null; 
    public ImageService()
    {
        try {

            Path dirPath = Paths.get("src/main/resources/static/profile");
            DIR = dirPath.toFile().getAbsolutePath();
            System.out.println("Profile directory path: " + DIR);

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    public  byte[] getData(String name )
    {
        try {

        FileInputStream fos =new FileInputStream(DIR+File.separator+name);
        return fos.readAllBytes();

        }catch ( Exception error )
        {
            error.printStackTrace();
            return null ;
        }
    }
    public boolean  save(MultipartFile part )
    {
        try {
            FileOutputStream file=new FileOutputStream(DIR+File.separator+part.getOriginalFilename()); 
            file.write(part.getInputStream().readAllBytes());
            file.close(); 
            return true; 
        } catch (Exception e) {

            e.printStackTrace(); 
            return false; 
        }
    }
    public boolean delete(String fileName)
    {
        try {
            File file=new File(DIR+fileName); 
            if (file.exists()) {
                file.delete(); 
                return true; 
            }else 
            {
                return false; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }
    }
}
