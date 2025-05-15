import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        String algorithm = args[0];
        String file = args[1];

        ArrayList<Task> tasks = readTasks(file);

        Algorithm scheduler;
        switch(algorithm.toLowerCase()) {
            case "fcfs": scheduler = new FCFS(tasks); break;
            case "sjf": scheduler = new SJF(tasks); break;
            case "prioritysc": scheduler = new PrioritySc(tasks); break;
            case "rr": scheduler = new RR(new LinkedList<>(tasks)); break;
            case "rrp": scheduler = new RRP(tasks); break;
            default: System.err.println("Wrong algorithm: " + algorithm); return;
        }
        scheduler.schedule();
    }

    public static ArrayList<Task> readTasks(String file) {
        ArrayList<Task> tasks = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(",");
                if(splitLine.length == 3) {
                    String name = splitLine[0].trim();
                    int prior = Integer.parseInt(splitLine[1].trim());
                    int burst = Integer.parseInt(splitLine[2].trim());

                    tasks.add(new Task(name, prior, burst));
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        } 
        return tasks;
    }
}
