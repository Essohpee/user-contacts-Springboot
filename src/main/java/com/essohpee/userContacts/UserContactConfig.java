package com.essohpee.userContacts;

import com.essohpee.userContacts.model.UserContact;
import com.essohpee.userContacts.repository.UserContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class UserContactConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserContactRepository repository){
        return args -> {
            UserContact samuel = new UserContact(
                    "Samuel Overs Pelham",
                    "sopelham@gmail.com",
                    "+231-776-547-717",
                    LocalDate.of( 1993, 2,24),
                    LocalDateTime.now());
            repository.saveAll(
                    List.of(samuel)
            );
        };
    }
}
