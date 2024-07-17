package visu.exceptions;

/**
 * Throw exception when scheduler has a problem during initialization
 */
public class SchedulerInitializationException extends Exception {

	private static final long serialVersionUID = -1034853061387029641L;

	public SchedulerInitializationException(String message) {
		super("Exception during scheduler initialisation: " + message);
	}

}
