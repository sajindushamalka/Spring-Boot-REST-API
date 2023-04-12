package com.example.demo8.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo8.model.Task;
import com.example.demo8.repositary.taskRepositary;

@Service
public class taskService {
    
    @Autowired
    private taskRepositary reop;

    //CRUD
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return reop.save(task);
    }

    public List<Task> findAllTask(){
        return reop.findAll();
    }

    public Task getTaskById(String taskId){
        return reop.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return reop.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assinee){
        return reop.getTaskByAssignee(assinee);
    }

    public Task updateTask(Task taskRequest){
        //get the exsting document from DB
        Task exitingtask = reop.findById(taskRequest.getTaskId()).get();
        exitingtask.setDescription(taskRequest.getDescription());
        exitingtask.setSeverity(taskRequest.getSeverity());
        exitingtask.setAssinee(taskRequest.getAssinee());
        exitingtask.setStoryPoint(taskRequest.getStoryPoint());

        return reop.save(exitingtask);
    }

    public String deleteTask(String taskId){
        reop.deleteById(taskId);
        return "Task Deleted from dashboard" + taskId;
    }
}
