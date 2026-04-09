package com.example.ToDo.Model;

import com.example.ToDo.Repository.TaskRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class MongodbDataLoader {

    @Bean
    CommandLineRunner runner(TaskRepository repository) {
        return args -> {
            // Only insert if the collection is empty
            if (repository.count() == 0) {
                ObjectMapper mapper = new ObjectMapper();
                TypeReference<List<Task>> typeReference = new TypeReference<List<Task>>(){};

                try (InputStream inputStream = TypeReference.class.getResourceAsStream("/taskdata.json")) {
                    List<Task> tasks = mapper.readValue(inputStream, typeReference);
                    repository.saveAll(tasks);
                    System.out.println("Data successfully loaded from JSON!");
                }
                catch (Exception e) {
                    System.out.println("Unable to load data: " + e.getMessage());
                }
            }
        };
    }

}
