import java.util.*;

public class RR implements Algorithm {
    private Queue<Task> queue;
    private final int QUANTUM = 4; // time quantum

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

        if (task.getBurst() > QUANTUM) { // if task's burst is greater than quantum, run for quantum and add it back to the queue with updated burst
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
