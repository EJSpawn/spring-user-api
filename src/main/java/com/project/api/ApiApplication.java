package com.project.api;

import java.util.Date;
import java.util.Random;

import javax.annotation.PostConstruct;

import com.project.api.user.model.User;
import com.project.api.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	@Transactional
	public void onLoad(){
		Random rdn = new Random();
		for(int aux = 1; aux < 10000; aux++){
			User usr = new User();
			usr.setName("Name_" + rdn.nextInt(100000));
			usr.setRegisterDate(new Date());
			userRepository.save(usr);
		}		
	}
}
