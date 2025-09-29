package com.example.tasks.core.usecases;

import com.example.tasks.core.entities.Task;
import com.example.tasks.infrastructure.InMemoryTaskRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateTaskTitleTest {
    @Test
    void updatesTitleSuccessfully() {
        var repo = new InMemoryTaskRepository();
        var task = new Task("1", "Old title");
        repo.save(task);

        var usecase = new UpdateTaskTitle(repo);
        var updated = usecase.execute("1", "New title");

        assertEquals("New title", updated.getTitle());
    }

    @Test
    void throwsWhenTaskNotFound() {
        var repo = new InMemoryTaskRepository();
        var usecase = new UpdateTaskTitle(repo);

        assertThrows(IllegalArgumentException.class, () -> {
            usecase.execute("42", "Doesn't matter");
        });
    }

    @Test
    void throwsWhenNewTitleIsEmpty() {
        var repo = new InMemoryTaskRepository();
        var task = new Task("1", "Valid title");
        repo.save(task);

        var usecase = new UpdateTaskTitle(repo);

        assertThrows(IllegalArgumentException.class, () -> {
            usecase.execute("1", "   ");
        });
    }
}