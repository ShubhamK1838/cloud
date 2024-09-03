package com.cloud;


import com.cloud.model.entity.File;
import com.cloud.model.entity.User;
import com.cloud.model.repository.FileRepository;
import org.apache.catalina.filters.SessionInitializerFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;


@SpringBootApplication
public class CloudApplication {


	public static void main(String[] args) {
		var context= SpringApplication.run(CloudApplication.class, args);




//		System.out.println(context.getBean(SessionFactory.class).toString());

//		SessionFactory sessionFactory= context.getBean(SessionFactory.class);
//		context.close();

//			Session session=sessionFactory.openSession();
//			File file =session.get(File.class,1);
//			Transaction tx= session.beginTransaction();
//
//			session.remove(file);
//
//			tx.commit();
//			session.close();
//			sessionFactory.close();
//		File file = repo.findById(3).get();
//		System.out.println(file );
//		var userRepo=context.getBean("userRepository", UserRepository.class);
//		var fileRepo=context.getBean("fileRepository", FileRepository.class);
//
//		User user=userRepo.findById(3).get();
//
//		File file=new File();
//		file.setName("this is first");
//		file.setUser(user);
//		file.setType("this is type ");
//
//
//		System.out.println(file);
//
//		fileRepo.save(file);
//
//
//
//		context.close();



	}

}
