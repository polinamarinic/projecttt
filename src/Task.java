/**
 * Represents a Task to be scheduled by an algorithm.
 */
import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private String name;
    private int priority;
    private int burst;
    private static final AtomicInteger next = new AtomicInteger();
    private int tid;
    
      
    /**
     * Creates a new Task with the given name, priority, and CPU burst time.
     * @param name the name of the task
     * @param priority the priority of the task (1 to 10)
     * @param burst the CPU burst time in milliseconds
     */
    public Task(String name, int priority, int burst) {
        this.tid = next.getAndIncrement();
        this.name = name;
        this.priority = priority;
        this.burst = burst;
    }

     /**
     * Returns the name of the task.
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the priority of the task.
     * @return the task priority
     */
    public int getPriority() {
        return priority;
    }

     /**
     * Sets the burst time of the task.
     * @param burst the new burst time
     */
    public void setBurst(int burst) {
        this.burst = burst;
    }

     /**
     * Returns the burst time of the task.
     * @return the CPU burst time
     */
    public int getBurst() {
        return burst;
    }

    /**
    * Returns a string representation of the task.
    * Format: [TaskName] PriorityX, Burst: Y
    *
    * @return a string describing the task
    */
    public String toString() {
        return "[" + name + "] Priority" + priority + ", Burst: " + burst; 
    }

    /**
    * Returns the unique task ID.
    *
    * @return the task identifier (tid)
    */
    public int getTid() {
        return tid;
    }
}
