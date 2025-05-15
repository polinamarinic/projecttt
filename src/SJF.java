/**
 * Implements the Shortest Job First (SJF) scheduling algorithm.
 * Tasks with the shortest CPU burst time are executed first.
 */
import java.util.*;

public class SJF implements Algorithm {
    private ArrayList<Task> queue;

     /**
     * Creates a new SJF scheduler with the given list of tasks.
     * @param tasks the list of tasks to schedule
     */
    public SJF(ArrayList<Task> tasks) {
        this.queue = new ArrayList<>(tasks);
    }

      /**
     * Schedules all tasks by picking the one with the shortest burst time.
     */
    @Override
    public void schedule() {
        while (!queue.isEmpty()) {
            Task current = pickNextTask();
            CPU.run(current);
        }
    }

     /**
     * Picks and removes the task with the shortest burst time.
     * @return the next task to run
     */
    @Override
    public Task pickNextTask() {
        if (queue.isEmpty()) return null;

        Task shortest = queue.get(0); // make first task shortest 
        for (int i = 1; i < queue.size(); i++) {
            Task task = queue.get(i);

            if (task.getBurst() < shortest.getBurst()) { // update shortest if found shorter than initially
                shortest = task;
            }
        }

        queue.remove(shortest);
        return shortest;
    }
}
