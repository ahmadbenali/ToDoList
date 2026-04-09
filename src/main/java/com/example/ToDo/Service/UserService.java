package com.example.ToDo.Service;

import com.example.ToDo.Model.Task;
import com.example.ToDo.Model.User;
import com.example.ToDo.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {this.repository = repository;}

    public Iterable<User> getALl()
    {
        return repository.findAll();
    }

}
