package com.cloud.model.service;

import com.cloud.model.entity.File;
import com.cloud.model.entity.User;
import com.cloud.model.handler.FileHandler;
import com.cloud.model.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class FileService {

    @Autowired
    private UserService userService;
    @Autowired
    private FileRepository repo;
    @Autowired
    private FileHandler fileHandler;

    public List<File> getUserFiles(User user )
    {
        return repo.findByUser(user);
    }


    public boolean delete(int id )
    {
        try {

            com.cloud.model.entity.File  file=repo.findById(id).get();
            return delete(file);
        }catch (Exception error)
        {
            error.printStackTrace();
            return false;
        }
    }
    public boolean deleteUserAllFiles(User user) {
        try {
            repo.deleteByUser(user);
            return true;
        }
        catch (Exception error)
        {
            error.printStackTrace();
            return false;
        }
    }

    public boolean delete(File file )
    {
        try {

            boolean result=fileHandler.delete(file);
            if(result)
            {
                repo.remove(file.getFid());
                return true;
            }else {
                return false;
            }

        }catch (Exception error)
        {
            error.printStackTrace();
            return false;
        }
    }

    public File save(File file )
    {
        try {
            if(file==null)
            {
                return null;
            }else
            {
                return repo.save(file);
            }
        }catch (Exception error)
        {
            error.printStackTrace();
            return null;
        }
    }
}
