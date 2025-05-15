/**
 * Simulates the CPU running tasks.
 */
public class CPU {
    /**
     * Runs the given task by printing its name and simulating execution.
     * @param task the task to run
     */
    public static void run(Task task) {
        System.out.println("Running task: " + task.getName());

        try {
            Thread.sleep(task.getBurst()); // pause thread for the burst duration
        } catch (InterruptedException e) {
            System.out.println("Task interrupted");
        }
        System.out.println("Task " + task.getName() + " finished execution");
    }
}