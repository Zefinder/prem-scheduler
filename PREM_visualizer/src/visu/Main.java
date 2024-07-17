package visu;

import visu.process.tasks.PremTask;
import visu.process.tasks.PriorityTask;
import visu.process.tasks.Processor;
import visu.process.tasks.Task;

public class Main {
	
	public static void main(String args[]) {
		Task tau1 = new PriorityTask(new PremTask("tau1", 15, 15, 2, 6), 1);
		Task tau2 = new PriorityTask(new PremTask("tau2", 16, 16, 4, 3), 2);
		Task tau3 = new PriorityTask(new PremTask("tau3", 20, 20, 7, 4), 1);
		
		Processor cpu0 = new Processor(0, tau1, tau2);
		Processor cpu1 = new Processor(1, tau3);
		Processor cpu2 = new Processor(2);
		
		System.out.println("Task set:");
		System.out.println(cpu0.toString());
		System.out.println(cpu1.toString());
		System.out.println(cpu2.toString());
	}

}
