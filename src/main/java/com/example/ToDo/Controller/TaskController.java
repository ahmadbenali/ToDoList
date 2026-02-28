package com.example.ToDo.Controller;


import com.example.ToDo.Model.Task;
import com.example.ToDo.Service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }


    @GetMapping
    public Iterable<Task> getAll(){

        return service.getALl();
    }

}
