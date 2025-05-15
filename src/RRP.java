/**
 * Implements Priority with Round-Robin scheduling.
 * Higher priority tasks run first. Tasks with the same priority use round-robin.
 */
import java.util.*;

public class RRP implements Algorithm {
    private Queue<Task> queue;
    private final int QUANTUM = 10;

    /**
     * Creates a new RRP scheduler from the list of tasks.
     * @param tasks the list of tasks to schedule
     */
    public RRP(List<Task> tasks) { 
        for (int i = 0; i < tasks.size(); i++) { // sort by priority, highest first
            for (int j = i + 1; j < tasks.size(); j++) {
                if (tasks.get(i).getPriority() < tasks.get(j).getPriority()) {
                    Task temp = tasks.get(i);
                    tasks.set(i, tasks.get(j));
                    tasks.set(j, temp);
                }
            }
        }
        queue = new LinkedList<>(tasks);
    }

    /**
     * Schedules tasks in order of priority and uses round-robin for same-priority tasks.
     */
    @Override
    public void schedule() {
        while (!queue.isEmpty()) {
            pickNextTask();
        }
    }

    /**
     * Picks the next task from the highest priority queue and runs it.
     * If the task's burst is greater than the time quantum, it is run for the quantum and re-added to the queue.
     * Otherwise, it is run to completion.
     * 
     * @return the task that was just run
     */
    @Override
    public Task pickNextTask() {
        if (queue.isEmpty()) return null;

        Task task = queue.poll();

        int runTime;

        if (task.getBurst() > QUANTUM) { // if burst higher than quantum, run for quantum and update burst
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