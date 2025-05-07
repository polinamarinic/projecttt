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

        int runTime;

        if (task.getBurst() > QUANTUM) {
            runTime = QUANTUM;
            task.setBurst(task.getBurst() - QUANTUM);
            queue.add(task);
        }
        else {
            runTime = task.getBurst();
            task.setBurst(0);
        }

        CPU.run(task);
        System.out.println("Task " + task.getName() + " ran for " + runTime + "ms");
        
        return task;
    }
}
