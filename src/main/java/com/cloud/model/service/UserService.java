package com.cloud.model.service;

import com.cloud.model.entity.User;
import com.cloud.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository repo; 
    @Autowired
    private ImageService fileService;


    public boolean delete(User user)
    {
        try {
            fileService.delete(user.getImageName());
            System.out.println(user.getImageName());
            repo.delete(user);
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public User authenticate(String username, String password) {
        User user =repo.findByEmailAndPassword(username, password);
        if(user!=null)
        {
             user.setImageData(fileService.getData(user.getImageName()));
            return user;
        }
        else
        {
            return null;
        }

    }
    public boolean delete(int id )
    {
        try {
            Optional<User> userOptional= repo.findById(id);
            if(!userOptional.isPresent())
                return false;
            User user=userOptional.get();
            fileService.delete(user.getImageName());
            repo.delete(user);
            return true;
        }catch ( Exception e )
        {
            e.printStackTrace();
            return false;
        }
    }
    public User update(User user)
    {
        return repo.save(user);
    }
    public User create(User user)
    {
        try {
            fileService.save(user.getFile());
            return repo.save(user);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
