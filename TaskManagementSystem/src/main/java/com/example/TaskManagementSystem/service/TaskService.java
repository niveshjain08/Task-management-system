package com.example.TaskManagementSystem.service;

import com.example.TaskManagementSystem.Model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Task createTask(Task task);

    List<Task> findAllTask();

    Task updateTask(Task task);
}
