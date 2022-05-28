package com.kraken.userservice;

import com.kraken.userservice.modal.Role;
import com.kraken.userservice.modal.User;
import com.kraken.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "Jack Perelta", "jack", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Sam Smith", "sammy", "23456", new ArrayList<>()));
            userService.saveUser(new User(null, "Sanda Banda", "sandab", "211654", new ArrayList<>()));
            userService.saveUser(new User(null, "Saikat SM", "saikat52", "sasa645", new ArrayList<>()));
            userService.saveUser(new User(null, "Kaitas Das", "kaitas", "kai123", new ArrayList<>()));
            userService.saveUser(new User(null, "Dragon Damodar", "Ddragon", "ddraganthat", new ArrayList<>()));

            userService.addRoleToUser("saikat52", "ROLE_ADMIN");
            userService.addRoleToUser("saikat52", "ROLE_USER");

            userService.addRoleToUser("sammy", "ROLE_USER");

            userService.addRoleToUser("kaitas", "ROLE_USER");
            userService.addRoleToUser("kaitas", "ROLE_MANAGER");

            userService.addRoleToUser("sandab", "ROLE_USER");
            userService.addRoleToUser("Ddragon", "ROLE_USER");
            userService.addRoleToUser("jack", "ROLE_USER");
        };
    }

}
