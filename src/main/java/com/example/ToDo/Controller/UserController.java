package com.example.ToDo.Controller;

import com.example.ToDo.Model.Task;
import com.example.ToDo.Model.User;
import com.example.ToDo.Service.TaskService;
import com.example.ToDo.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public Iterable<User> getAll(){

        return service.getALl();
    }
}
