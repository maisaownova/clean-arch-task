package com.example.tasks.core.usecases;

import com.example.tasks.core.entities.Task;
import com.example.tasks.infrastructure.InMemoryTaskRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListAllTasksTest {
    @Test
    void returnsAllSavedTasks() {
        var repo = new InMemoryTaskRepository();
        repo.save(new Task("1", "Prepare monthly report"));
        repo.save(new Task("2", "Close Q3 books"));

        var usecase = new ListAllTasks(repo);
        List<Task> tasks = usecase.execute();

        assertEquals(2, tasks.size());
        assertTrue(tasks.stream().anyMatch(t -> t.getTitle().equals("Prepare monthly report")));
        assertTrue(tasks.stream().anyMatch(t -> t.getTitle().equals("Close Q3 books")));
    }

    @Test
    void returnsEmptyListWhenNoTasksExist() {
        var repo = new InMemoryTaskRepository();
        var usecase = new ListAllTasks(repo);

        List<Task> tasks = usecase.execute();

        assertTrue(tasks.isEmpty());
    }
}
