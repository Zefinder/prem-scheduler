package visu.process.tasks;

/**
 * This is the object representation of the PREM task model. This model is
 * composed of two segments:
 * <ul>
 * <li>Memory phase
 * <li>Computation phase
 * </ul>
 * 
 * The computation phase and memory phase filled in an instance is always the
 * worst case time
 * 
 * @author Adrien Jakubiak
 */
public class PremTask extends Task {

	// Memory phase
	private final int memoryPhaseDuration;

	// Computation phase
	private final int computationPhaseDuration;

	/**
	 * Initializes a new PREM task with all important informations. Remember that
	 * both memory and computation phases durations MUST BE worst case
	 * 
	 * @param name                     the task name
	 * @param period                   the task period
	 * @param deadline                 the task deadline
	 * @param memoryPhaseDuration      the memory phase duration (must be worst
	 *                                 case)
	 * @param computationPhaseDuration the computation phase duration (must be worst
	 *                                 case)
	 */
	public PremTask(String name, int period, int deadline, int memoryPhaseDuration, int computationPhaseDuration) {
		super(name, period, deadline, 0);
		this.memoryPhaseDuration = memoryPhaseDuration;
		this.computationPhaseDuration = computationPhaseDuration;
	}

	/**
	 * Initializes a new PREM task with all important informations. Remember that
	 * both memory and computation phases durations MUST BE worst case
	 * 
	 * @param name                     the task name
	 * @param period                   the task period
	 * @param deadline                 the task deadline
	 * @param startTime                the task start time
	 * @param memoryPhaseDuration      the memory phase duration (must be worst
	 *                                 case)
	 * @param computationPhaseDuration the computation phase duration (must be worst
	 *                                 case)
	 */
	public PremTask(String name, int period, int deadline, int startTime, int memoryPhaseDuration,
			int computationPhaseDuration) {
		super(name, period, deadline, startTime);
		this.memoryPhaseDuration = memoryPhaseDuration;
		this.computationPhaseDuration = computationPhaseDuration;
	}

	public int getMemoryPhaseDuration() {
		return memoryPhaseDuration;
	}

	public int getComputationPhaseDuration() {
		return computationPhaseDuration;
	}

	@Override
	public int getWorstExecutionTime() {
		return memoryPhaseDuration + computationPhaseDuration;
	}

	@Override
	public String toString() {
		return "PREMTask[%s,M=%d,C=%d]".formatted(super.toString(), memoryPhaseDuration, computationPhaseDuration);
	}

}
