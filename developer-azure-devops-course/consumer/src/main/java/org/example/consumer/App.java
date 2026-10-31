package org.example.consumer;

import org.example.training.Task;
import org.example.training.TaskService;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        TaskService service = new TaskService();
        Task task = service.add("Consume the published Maven package");
        System.out.println(service.complete(task.id()));
    }
}
