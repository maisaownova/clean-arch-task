package com.example.tasks.core.usecases;

import com.example.tasks.core.entities.Task;
import com.example.tasks.infrastructure.InMemoryTaskRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskTest {
    @Test
    void deletesExistingTask() {
        var repo = new InMemoryTaskRepository();
        var task = new Task("1", "Prepare monthly report");
        repo.save(task);

        var usecase = new DeleteTask(repo);
        usecase.execute("1");

        assertTrue(repo.findAll().isEmpty());
    }

    @Test
    void throwsWhenTaskDoesNotExist() {
        var repo = new InMemoryTaskRepository();
        var usecase = new DeleteTask(repo);

        assertThrows(IllegalArgumentException.class, () -> usecase.execute("404"));
    }
}
