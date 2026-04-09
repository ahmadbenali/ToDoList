package com.example.ToDo.Model;

import com.example.ToDo.Repository.TaskRepository;
import com.example.ToDo.Repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class LoadUser {
    @Bean
    //see why runner1 has conflect with runner
    CommandLineRunner runner1(UserRepository repository) {
        return args -> {
            // Only insert if the collection is empty
            if (repository.count() == 0) {
                ObjectMapper mapper = new ObjectMapper();
                TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};

                try (InputStream inputStream = TypeReference.class.getResourceAsStream("/userdata.json")) {
                    List<User> users = mapper.readValue(inputStream, typeReference);
                    repository.saveAll(users);
                    System.out.println("Data successfully loaded from JSON!");
                }
                catch (Exception e) {
                    System.out.println("Unable to load data: " + e.getMessage());
                }
            }
        };
    }
}
