package com.BlogAppApis;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BlogAppApis.repo.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication /* implements CommandLineRunner */ {

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	// @Override
	// public void run(String... args) throws Exception {

	// }

}
