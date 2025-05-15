import java.util.*;
public class FCFS implements Algorithm {
    private ArrayList<Task> queue;

    public FCFS(ArrayList<Task> tasks) {
        this.queue = new ArrayList<>(tasks);
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            Task next = pickNextTask();
            CPU.run(next);
        }
    }

    public Task pickNextTask() {
        if(!queue.isEmpty()) return queue.remove(0); // return the first task if not empty
        else return null;
    }
}
