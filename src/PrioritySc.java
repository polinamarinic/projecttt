/**
 * Implements Priority Scheduling.
 * Tasks with higher priority values are executed first.
 */
import java.util.*;

public class PrioritySc implements Algorithm {
    private ArrayList<Task> queue;

    /**
     * Creates a new Priority scheduler with the given list of tasks.
     * @param tasks the list of tasks to schedule
     */
    public PrioritySc(ArrayList<Task> tasks) {
        this.queue = new ArrayList<>(tasks);
    }

    /**
     * Schedules tasks based on their priority value.
     */
    @Override
    public void schedule() {
        while (!queue.isEmpty()) {
            Task next = pickNextTask();
            CPU.run(next);
        }
    }

    /**
     * Picks and removes the task with the highest priority.
     * @return the next task to run
     */
    @Override
    public Task pickNextTask() {
        if (queue.isEmpty()) return null;

        Task high = queue.get(0); // assume first as highest
        for (int i = 1; i < queue.size(); i++) {
            Task task = queue.get(i);

            if (task.getPriority() > high.getPriority()) { // if current has higher priority, update high
                high = task;
            }
        }

        queue.remove(high);
        return high;
    }
}
