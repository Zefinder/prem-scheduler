package visu.process.tasks;

/**
 * This class is a template class to create a task object. We assume that tasks
 * are periodic, have a deadline and have a name!
 * 
 * @author Adrien Jakubiak
 */
public abstract class Task {

	// Name identifier to display
	private final String name;

	// Period, deadline and start time of the task
	private final int period;
	private final int deadline;
	private final int startTime;

	/**
	 * Initializes a new task with all important informations. If you want that the
	 * deadline is the next period, just put the same values.
	 * 
	 * @param name the task name to display
	 * @param period the task period
	 * @param deadline the task deadline
	 * @param startTime the task start time
	 */
	public Task(String name, int period, int deadline, int startTime) {
		this.name = name == null ? "" : name; // Null catcher
		this.period = period;
		this.deadline = deadline;
		this.startTime = startTime;
	}

	/**
	 * Returns the worst execution time for that task
	 * 
	 * @return the worst execution time for that task
	 */
	public abstract int getWorstExecutionTime();

	/**
	 * Returns the task name
	 * 
	 * @return the task name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the task period
	 * 
	 * @return the task period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * Returns the task deadline
	 * 
	 * @return the task deadline
	 */
	public int getDeadline() {
		return deadline;
	}

	/**
	 * Returns the task start time
	 * 
	 * @return the task start time
	 */
	public int getStartTime() {
		return startTime;
	}

	@Override
	public String toString() {
		return "name=%s,T=%d,D=%d,WCET=%d,start=%d".formatted(name, period, deadline, getWorstExecutionTime(),
				startTime);
	}
}
