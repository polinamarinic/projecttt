# CPU Scheduling Algorithms (Java Project)
This project simulates 5 CPU scheduling algorithms. It is written in Java and demonstrates how tasks can be scheduled based on different algorithms which base on arrival, CPU burst time and priority.

## Algorithms Implemented
1. **First-Come, First-Served (FCFS)** – Tasks are executed in the order they arrive.
2. **Shortest Job First (SJF)** – Tasks with the shortest CPU burst are executed first.
3. **Priority Scheduling** – Tasks with higher priority (higher is more prioritized) are executed first.
4. **Round-Robin (RR)** – Each task runs for a time quantum (4 ms) in a cyclic manner.
5. **Priority with Round-Robin (RRP)** – Tasks are grouped by priority, and Round-Robin is used for tasks with the same priority.

## Assumptions
- All tasks arrive at the same time.
- Input format: Each task is defined in a text file (`schedule.txt`) with lines like:
```bash
T1, 4, 8 
T2, 2, 6
T3, 1, 10
T4, 3, 4
T5, 5, 2
Format: [Task Name], [Priority], [CPU Burst]
```
## How to Run
Compile and run from the terminal:
```bash
javac *.java
java Driver [algorithm] schedule.txt
```
Replace [algorithm] with one of:  
fcfs  
sjf  
prioritysc  
rr  
rrp
```bash
Example:
java Driver fcfs schedule.txt
```
## Project Structure
1.**Driver.java** – Reads the task file and runs the selected algorithm.
2.**Task.java** – Stores task information: name, priority, burst, tid.
3.**CPU.java** – Simulates running a task.  
4.**Algorithm.java** – Interface for scheduling algorithms.  
5.**FCFS.java, SJF.java, PrioritySc.java, RR.java, RRP.java** – Implement the five scheduling algorithms.

## Challenges
- Managing task queues with different data structures (ArrayList vs Queue).  
- Implementing fair Round-Robin scheduling logic.  
- Ensuring correct interface usage and Java syntax.

## Author
Polina Marinic U224N0824  
COMP354 – Operating Systems Project 1
