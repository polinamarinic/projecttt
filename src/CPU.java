public class CPU {
    public static void run(Task task) {
        System.out.println("Running task: " + task.getName());

        try {
            Thread.sleep(task.getBurst());
        } catch (InterruptedException e) {
            System.out.println("Task interrupted");
        }
        System.out.println("Task " + task.getName() + " finished execution");
    }
}
