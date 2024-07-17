package visu.process.scheduler;

import java.util.ArrayList;
import java.util.List;

import visu.exceptions.SchedulerInitializationException;
import visu.process.tasks.PremTask;
import visu.process.tasks.PriorityTask;
import visu.process.tasks.Processor;
import visu.process.tasks.Task;

/**
 * This scheduler only uses PREM tasks with priority, be sure to use PREM tasks
 * with priority when you use it.
 * 
 * @author Adrien Jakubiak
 */
public class MemoryCentricScheduler {

	// Processor list
	private final List<Processor> cpuList;

	public MemoryCentricScheduler(Processor... processors) throws SchedulerInitializationException {
		cpuList = new ArrayList<Processor>();

		for (Processor cpu : processors) {
			// Check if all tasks are prority tasks and PREM
			for (Task task : cpu.getTaskList()) {
				if (!(task instanceof PriorityTask)) {
					// Stop everything because not priority task
					throw new SchedulerInitializationException(
							"Task to be scheduled is not a priority task: %s".formatted(task.toString()));

				}

				if (!(((PriorityTask) task).getTask() instanceof PremTask)) {
					// Stop everything because not PREM
					throw new SchedulerInitializationException(
							"Task to be scheduled is not a PREM task: %s".formatted(task.toString()));
				}
			}
			
			// From here we know that this CPU is ready to be scheduled
			cpuList.add(cpu);
		}
	}

}
