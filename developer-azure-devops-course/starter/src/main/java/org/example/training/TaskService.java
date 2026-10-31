package org.example.training;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public final class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    public Task add(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Task title must not be blank");
        }
        Task task = new Task(nextId++, title.strip(), false);
        tasks.add(task);
        return task;
    }

    public Task complete(long id) {
        for (int index = 0; index < tasks.size(); index++) {
            Task task = tasks.get(index);
            if (task.id() == id) {
                Task completed = new Task(task.id(), task.title(), true);
                tasks.set(index, completed);
                return completed;
            }
        }
        throw new NoSuchElementException("No task with id " + id);
    }

    public List<Task> list() {
        return List.copyOf(tasks);
    }
}
