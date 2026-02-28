package com.example.ToDo.Repository;

import com.example.ToDo.Model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,String> {
}
