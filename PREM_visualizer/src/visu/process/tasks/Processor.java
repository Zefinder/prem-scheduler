package visu.process.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * This is just a CPU... Put tasks in it and then... Well schedule it I guess
 * 
 * @author Adrien Jakubiak
 */
public class Processor {

	// Processor number (its priority)
	private final int cpuNumber;

	// List of tasks on the processor
	private final List<Task> taskList;

	/**
	 * Initializes a new CPU with it's identifier. Note that it's number will
	 * determine it's priority!
	 * 
	 * @param cpuNumber the CPU identifier which is also his priority
	 */
	public Processor(int cpuNumber) {
		this.cpuNumber = cpuNumber;
		this.taskList = new ArrayList<Task>();
	}

	/**
	 * Initializes a new CPU with it's identifier. Note that it's number will
	 * determine it's priority!
	 * 
	 * @param cpuNumber the CPU identifier which is also his priority
	 * @param tasks     tasks that you want to link to the CPU
	 */
	public Processor(int cpuNumber, Task... tasks) {
		this.cpuNumber = cpuNumber;
		this.taskList = new ArrayList<Task>();
		for (Task task : tasks) {
			taskList.add(task);
		}
	}

	/**
	 * Adds a task to the CPU task list
	 * 
	 * @param task the task to add
	 */
	public void addTask(Task task) {
		taskList.add(task);
	}

	/**
	 * Returns the CPU identifier
	 * 
	 * @return the CPU identifier
	 */
	public int getCpuNumber() {
		return cpuNumber;
	}

	/**
	 * Returns the task list
	 * 
	 * @return the task list
	 */
	public List<Task> getTaskList() {
		return taskList;
	}

	@Override
	public String toString() {
		String str = "On CPU %d:".formatted(cpuNumber);
		if (taskList.isEmpty()) {
			str += "\n\tNo tasks";
		} else {
			for (Task task : taskList) {
				str += "\n\t%s".formatted(task.toString());
			}
		}

		return str;
	}
}
