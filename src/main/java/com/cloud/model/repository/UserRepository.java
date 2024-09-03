package com.cloud.model.repository;

import com.cloud.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface  UserRepository extends CrudRepository<User,Integer> {

    public User findByEmailAndPassword(String email, String password);


}
