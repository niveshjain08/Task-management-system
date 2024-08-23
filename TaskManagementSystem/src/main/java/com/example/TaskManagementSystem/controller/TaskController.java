package com.example.TaskManagementSystem.controller;

import com.example.TaskManagementSystem.Model.Task;
import com.example.TaskManagementSystem.service.TaskService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity newTask(@RequestBody Task task){

        Task newTask = taskService.createTask(task);

        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping("/findAllTask")
    public ResponseEntity getAllTask(){

        List<Task> allTask = taskService.findAllTask();

        return new ResponseEntity<>(allTask, HttpStatus.OK);
    }

    @PutMapping("/updateTask")
    public ResponseEntity updateTask(@RequestBody Task task){

        Task updatedTask = taskService.updateTask(task);

        return new ResponseEntity(updatedTask, HttpStatus.OK);
    }
}
