package com.cloud.model.repository;

import com.cloud.model.entity.File;
import com.cloud.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface  FileRepository extends CrudRepository<File,Integer> {


   public void deleteByFid(int id );
   
   public List<File> findByUser(User user );
   @Query("select f from File f  where f.user.id=:id")
   public List<File> findByUserId(@Param("id") Integer userId );

   public void deleteByUser(User user);

   @Modifying
   @Transactional
   @Query("delete from File  f where f.fid=:id ")
   public void remove(@RequestParam("id") int id );





}
