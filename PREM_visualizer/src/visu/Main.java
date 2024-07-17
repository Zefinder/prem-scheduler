package visu;

import javax.imageio.stream.MemoryCacheImageInputStream;

import visu.exceptions.SchedulerInitializationException;
import visu.process.scheduler.MemoryCentricScheduler;
import visu.process.tasks.PremTask;
import visu.process.tasks.PriorityTask;
import visu.process.tasks.Processor;
import visu.process.tasks.Task;

public class Main {

	public static void main(String args[]) throws SchedulerInitializationException {
		Task tau1 = new PriorityTask(new PremTask("tau1", 15, 15, 2, 6), 1);
		Task tau2 = new PriorityTask(new PremTask("tau2", 16, 16, 4, 3), 2);
		Task tau3 = new PriorityTask(new PremTask("tau3", 20, 20, 7, 4), 1);
		Task tau4 = new PremTask("tau4", 5, 5, 5, 5);
		Task tau5 = new PriorityTask(new Task("tau5", 6, 6, 6) {
			
			@Override
			public int getWorstExecutionTime() {
				// TODO Auto-generated method stub
				return 6;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Task[%s]".formatted(super.toString());
			}
			
		}, 2);

		Processor cpu0 = new Processor(0, tau1, tau2);
		Processor cpu1 = new Processor(1, tau3);
		Processor cpu2 = new Processor(2);
		Processor cpu3 = new Processor(3, tau4, tau5);

		System.out.println("Task set:");
		System.out.println(cpu0.toString());
		System.out.println(cpu1.toString());
		System.out.println(cpu2.toString());
		System.out.println(cpu3.toString());
		
		MemoryCentricScheduler scheduler = new MemoryCentricScheduler(cpu0, cpu1);
	}

}
