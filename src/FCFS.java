import java.util.*;
public class FCFS implements Algorithm {
    private ArrayList<Task> queue;

    public FCFS(ArrayList<Task> tasks) {
        this.queue = new ArrayList<>(tasks);
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            Task current = pickNextTask();
            System.out.println("Running task: " + current);
        }
    }

    public Task pickNextTask() {
        if(!queue.isEmpty()) return queue.remove(0);
        else return null;
    }
}
