/**
 * Implements the First-Come First-Served (FCFS) scheduling algorithm
 */
import java.util.*;
public class FCFS implements Algorithm {
    private ArrayList<Task> queue;

     /**
     * Creates a new FCFS scheduler with the given list of tasks.
     * @param tasks the list of tasks to schedule
     */
    public FCFS(ArrayList<Task> tasks) {
        this.queue = new ArrayList<>(tasks);
    }

     /**
     * Schedules the tasks in FCFS order.
     */
    @Override
    public void schedule() {
        while (!queue.isEmpty()) {
            Task next = pickNextTask();
            CPU.run(next);
        }
    }

     /**
     * Picks the next task in FCFS order.
     * @return the next task to run
     */
    @Override
    public Task pickNextTask() {
        if(!queue.isEmpty()) return queue.remove(0); // return the first task if not empty
        else return null;
    }
}
