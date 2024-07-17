package visu.process.tasks;

/**
 * This class allows a Task to get a priority. Note that priority are usually on
 * the same processor.
 * 
 * @author Adrien Jakubiak
 */
public class PriorityTask extends Task {

	// Save the worst case execution time
	private final int worstExecutionTime;

	// Task priority
	private final int priority;

	// Task toString string
	private final String taskToString;

	/**
	 * Initializes a new priority task from an already existing task
	 * 
	 * @param task the task to add priority to
	 * @param priority the priority to add to the task
	 */
	public PriorityTask(Task task, int priority) {
		super(task.getName(), task.getPeriod(), task.getDeadline(), task.getStartTime());
		this.worstExecutionTime = task.getWorstExecutionTime();
		this.priority = priority;
		this.taskToString = task.toString();
	}

	/**
	 * Returns the priority of that task
	 * 
	 * @return the task's priority
	 */
	public int getPriority() {
		return priority;
	}

	@Override
	public int getWorstExecutionTime() {
		return worstExecutionTime;
	}

	@Override
	public String toString() {
		return "%s,prio=%d".formatted(taskToString, priority);
	}
}
