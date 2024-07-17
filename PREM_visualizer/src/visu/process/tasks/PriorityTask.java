package visu.process.tasks;

/**
 * This class allows a Task to get a priority. Note that priority are usually on
 * the same processor. This acts like a decorator...
 * 
 * @author Adrien Jakubiak
 */
public class PriorityTask extends Task {

	// Task priority
	private final int priority;

	// Task toString string
	private final Task task;

	/**
	 * Initializes a new priority task from an already existing task
	 * 
	 * @param task the task to add priority to
	 * @param priority the priority to add to the task
	 */
	public PriorityTask(Task task, int priority) {
		super(task.getName(), task.getPeriod(), task.getDeadline(), task.getStartTime());
		this.task = task;
		this.priority = priority;
	}

	/**
	 * Returns the priority of that task
	 * 
	 * @return the task's priority
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * Returns wrapped task
	 * 
	 * @return wrapped task
	 */
	public Task getTask() {
		return task;
	}

	@Override
	public int getWorstExecutionTime() {
		return task.getWorstExecutionTime();
	}

	@Override
	public String toString() {
		return "%s,prio=%d".formatted(task.toString(), priority);
	}
}
