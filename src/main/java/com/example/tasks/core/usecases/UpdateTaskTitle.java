package com.example.tasks.core.usecases;

import com.example.tasks.application.TaskRepository;
import com.example.tasks.core.entities.Task;

public class UpdateTaskTitle {
    private final TaskRepository repo;

    public UpdateTaskTitle(TaskRepository repo) {
        this.repo = repo;
    }

    public Task execute(String id, String newTitle) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));

        if (newTitle == null || newTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        task.setTitle(newTitle);
        repo.save(task);
        return task;
    }
}