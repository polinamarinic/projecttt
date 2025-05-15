/**
 * Implements the Round-Robin (RR) scheduling algorithm.
 * Each task runs for a fixed time (quantum) or until it finishes.
 */
import java.util.*;

public class RR implements Algorithm {
    private Queue<Task> queue;
    private final int QUANTUM = 4; // time quantum

     /**
     * Creates a new Round-Robin scheduler using a queue of tasks.
     * @param tasks the queue of tasks to schedule
     */
    public RR(Queue<Task> tasks) {
        this.queue = tasks;
    }

     /**
     * Schedules tasks in a round-robin fashion using a fixed time quantum.
     */
    @Override
    public void schedule() {
        while (!queue.isEmpty()) {
            pickNextTask();
        }
    }

     /**
     * Picks the next task, runs it for a quantum, and puts it back in the queue if needed.
     * @return the task that was just run
     */
    @Override
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
