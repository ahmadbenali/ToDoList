package com.example.ToDo.Model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Setter
@Getter
@Document("Tasks")
public class Task {


    @Id
    private String id;
    private String title;
    private String description;

    public  Task() {}

    public Task(String id,String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
