import java.util.*;

public class RRP implements Algorithm {
    private Queue<Task> queue;
    private final int QUANTUM = 10;

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

    public void schedule() {
        while (!queue.isEmpty()) {
            pickNextTask();
        }
    }

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