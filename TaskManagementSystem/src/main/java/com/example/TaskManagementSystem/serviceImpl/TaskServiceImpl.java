package com.example.TaskManagementSystem.serviceImpl;

import com.example.TaskManagementSystem.Model.Task;
import com.example.TaskManagementSystem.repository.TaskRepository;
import com.example.TaskManagementSystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Override
    public Task createTask(Task task) {

        Task newTask = new Task();

        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setDueDate(task.getDueDate());
        newTask.setCreatedAt(task.getCreatedAt() != null ? task.getCreatedAt() : new Date());
        newTask.setUpdatedAt(task.getUpdatedAt() != null ? task.getUpdatedAt() : new Date());

        return taskRepository.save(newTask);
    }

    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task existingTask) {

        Task task = taskRepository.findById(existingTask.getId()).get();

        if(task!= null){
            task.setTitle(existingTask.getTitle());
            task.setDescription(existingTask.getDescription());
            task.setDueDate(existingTask.getDueDate());
            task.setUpdatedAt(new Date());

            return taskRepository.save(task);
        }
        return existingTask;
    }


}
