import java.util.*;

public class RR implements Algorithm {
    private Queue<Task> queue;
    private final int QUANTUM = 10;

    public RR(Queue<Task> tasks) {
        this.queue = tasks;
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            pickNextTask();
        }
    }

    public Task pickNextTask() {
        if (queue.isEmpty()) return null;

        Task task = queue.remove();

        if (task.getBurst() > QUANTUM) {
            System.out.println("Running task: " + task.getName() + " for " + QUANTUM + "ms");
            task.setBurst(task.getBurst() - QUANTUM);
            queue.add(task);
        }
        else System.out.println("Running task: " + task.getName() + " for " + task.getBurst() + "ms");
        
        return task;
    }
}
