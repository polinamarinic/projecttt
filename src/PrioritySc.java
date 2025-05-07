import java.util.*;
public class PrioritySc implements Algorithm {
    private ArrayList<Task> queue;

    public PrioritySc(ArrayList<Task> tasks) {
        this.queue = new ArrayList<>(tasks);
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            Task current = pickNextTask();
            System.out.println("Running task: " + current);
        }
    }

    public Task pickNextTask() {
        if (queue.isEmpty()) return null;

        Task high = queue.get(0);
        for (int i = 1; i < queue.size(); i++) {
            Task task = queue.get(i);

            if (task.getPriority() > high.getPriority()) {
                high = task;
            }
        }

        queue.remove(high);
        return high;
    }
}
