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
	
	// Period and deadline of the task
	private final int period;
	private final int deadline;

	public Task(String name, int period, int deadline) {
		this.name = name == null ? "" : name;
		this.period = period;
		this.deadline = deadline;
	}

	/**
	 * Returns the worst execution time for that task
	 * 
	 * @return the worst execution time for that task
	 */
	public abstract int getWorstExecutionTime();
	
	public String getName() {
		return name;
	}
	
	public int getPeriod() {
		return period;
	}
	
	public int getDeadline() {
		return deadline;
	}

	@Override
	public String toString() {
		return "Task[name=%s,T=%d,D=%d]".formatted(name, period, deadline);
	}
}
