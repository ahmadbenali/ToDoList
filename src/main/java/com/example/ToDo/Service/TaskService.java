package com.example.ToDo.Service;


import com.example.ToDo.Model.Task;
import com.example.ToDo.Repository.TaskRepository;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Iterable<Task> getALl()
    {
        return repository.findAll();
    }


}
