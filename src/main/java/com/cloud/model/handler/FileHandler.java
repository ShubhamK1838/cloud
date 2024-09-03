package com.cloud.model.handler;

import com.cloud.model.entity.File;
import com.cloud.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Component
public class FileHandler {

    private String DIR=null;

    public FileHandler(){
        try {

            Path dirPath = Paths.get("src/main/resources/static/storage");
            DIR = dirPath.toFile().getAbsolutePath();
            System.out.println("Profile directory path: " + DIR);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public File create( File file)
    {
        try {

            var fl=new java.io.File(DIR+java.io.File.separator+file.getName());
            if(fl.exists())
            {
                return null;
            }
            FileOutputStream out=new FileOutputStream(fl);

            InputStream io=file.getPart().getInputStream();
            byte[] buffer=new byte[1024*8];
            while((io.read(buffer))!=-1)
            {
                out.write(buffer);
            }
            out.close();
            return file;

        }catch (Exception error)
        {
            error.printStackTrace();
            return null;
        }
    }

    public boolean delete(File entity)
    {
        try {
            java.io.File file=new java.io.File(DIR+java.io.File.separator+entity.getName());

            if(file.exists())
            {
                file.delete() ;
                return true;
            }else
            {
                return false;
            }
        }catch ( Exception error )
        {
            error.printStackTrace();
            return false;
        }
    }
    public  static  File getEntityFile(MultipartFile part , User user  )
    {
        File file = new File();
        file.setName(part.getOriginalFilename());
        file.setSize(formatSize(part.getSize()));
        file.setType(part.getContentType());
        file.setUploadedDate(new Date());
        file.setUser(user);

        return file;
    }



        private static   String formatSize(long size) {
            if (size <= 0)
                return "0 B";
            final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
            int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
            return new java.text.DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " "
                    + units[digitGroups];
        }


}
