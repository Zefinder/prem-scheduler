package visu.process.tasks;

/**
 * This class allows a Task to get a priority. Note that priority are usually on
 * the same processor.
 */
public class PriorityTask extends Task {

	// Save the worst case execution time
	private final int worstExecutionTime;

	// Task priority
	private final int priority;

	public PriorityTask(Task task, int priotity) {
		super(task.getName(), task.getPeriod(), task.getDeadline());
		this.worstExecutionTime = task.getWorstExecutionTime();
		this.priority = priotity;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int getWorstExecutionTime() {
		return worstExecutionTime;
	}
}
