package com.cvita;

import com.cvita.models.Role;
import com.cvita.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CvitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvitaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository) {

        return args -> {

            if (roleRepository.findByRole("USER") == null) {
                Role newUserRole = new Role();
                newUserRole.setRole("USER");
                roleRepository.save(newUserRole);
            }
            if (roleRepository.findByRole("HR") == null) {
                Role newUserRole = new Role();
                newUserRole.setRole("HR");
                roleRepository.save(newUserRole);
            }
        };

    }
}
