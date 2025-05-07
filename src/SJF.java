import java.util.*;
public class SJF implements Algorithm {
    private ArrayList<Task> queue;

    public SJF(ArrayList<Task> tasks) {
        this.queue = new ArrayList<>(tasks);
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            Task current = pickNextTask();
            System.out.println("Running task: " + current);
        }
    }

    @Override
    public Task pickNextTask() {
        if (queue.isEmpty()) return null;

        Task shortest = queue.get(0);
        for (int i = 1; i < queue.size(); i++) {
            Task task = queue.get(i);

            if (task.getBurst() < shortest.getBurst()) {
                shortest = task;
            }
        }

        queue.remove(shortest);
        return shortest;
    }
}
