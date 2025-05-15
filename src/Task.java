import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private String name;
    private int priority;
    private int burst;
    private static final AtomicInteger next = new AtomicInteger();
    private int tid;
    
    public Task(String name, int priority, int burst) {
        this.tid = next.getAndIncrement();
        this.name = name;
        this.priority = priority;
        this.burst = burst;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public void setBurst(int burst) {
        this.burst = burst;
    }

    public int getBurst() {
        return burst;
    }

    public String toString() {
        return "[" + name + "] Priority" + priority + ", Burst: " + burst; 
    }

    public int getTid() {
        return tid;
    }
}
