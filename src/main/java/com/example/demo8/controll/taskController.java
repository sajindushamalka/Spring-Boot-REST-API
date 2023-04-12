package com.example.demo8.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo8.model.Task;
import com.example.demo8.service.taskService;

@RestController
@RequestMapping("/tasks")
public class taskController {

    @Autowired
    private taskService taskservice;

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskservice.addTask(task);
    }
    
    @GetMapping
    public List<Task> getTasks(){
        return taskservice.findAllTask();
    }
    
    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return taskservice.getTaskById(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskWithseverity(@PathVariable int severity){
        return taskservice.getTaskBySeverity(severity);
    }

    @GetMapping("/assinee/{assinee}")
    public List<Task> getTaskByssignee(@PathVariable String assinee){
        return taskservice.getTaskByAssignee(assinee);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return taskservice.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(String taskid){
        return taskservice.deleteTask(taskid);
    }

}
