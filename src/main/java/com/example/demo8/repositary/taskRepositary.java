package com.example.demo8.repositary;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo8.model.Task;

public interface taskRepositary extends MongoRepository<Task,String>{

    List<Task> findBySeverity(int severity);

    @Query("{assinee: ?0}")
    List<Task> getTaskByAssignee(String assinee);
    
}
