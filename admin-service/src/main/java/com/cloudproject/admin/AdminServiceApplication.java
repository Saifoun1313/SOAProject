package com.cloudproject.admin;

import com.cloudproject.admin.entity.Admin;
import com.cloudproject.admin.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AdminRepository adminRepository){
        return args -> {
            adminRepository.save(
                    new Admin(1L,"admin","admin",
                            "admin","admin",null));
            adminRepository.findAll().forEach(s->{
                System.out.println(s.toString());
            });
        };

    }
}
