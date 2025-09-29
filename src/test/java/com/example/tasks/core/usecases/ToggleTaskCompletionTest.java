package com.example.tasks.core.usecases;

import com.example.tasks.core.entities.Task;
import com.example.tasks.infrastructure.InMemoryTaskRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToggleTaskCompletionTest {
    @Test
    void togglesFromFalseToTrue() {
        var repo = new InMemoryTaskRepository();
        var task = new Task("1", "Prepare monthly report");
        repo.save(task);

        var usecase = new ToggleTaskCompletion(repo);
        var updated = usecase.execute("1");

        assertTrue(updated.isCompleted());
    }

    @Test
    void togglesFromTrueToFalse() {
        var repo = new InMemoryTaskRepository();
        var task = new Task("2", "Close Q3 books");
        task.toggleCompleted();
        repo.save(task);

        var usecase = new ToggleTaskCompletion(repo);
        var updated = usecase.execute("2");

        assertFalse(updated.isCompleted());
    }

    @Test
    void throwsWhenTaskDoesNotExist() {
        var repo = new InMemoryTaskRepository();
        var usecase = new ToggleTaskCompletion(repo);

        assertThrows(IllegalArgumentException.class, () -> usecase.execute("404"));
    }
}
