package org.example.training;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        TaskService tasks = new TaskService();
        Task first = tasks.add("Learn the developer workflow");
        tasks.add("Practice with a training work item");
        tasks.complete(first.id());
        for (Task task : tasks.list()) {
            System.out.printf("%d [%s] %s%n",
                    task.id(), task.completed() ? "done" : "open", task.title());
        }
    }
}
