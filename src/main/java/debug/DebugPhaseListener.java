package debug;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Shows the different phases of a JSF request.
 * DO NOT DEPLOY IN PRODUCTION as it puts a LOT of data in your
 * logfile, maybe enough to slow down your application.
 */
public class DebugPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 3303149225999676320L;
	private static final String PROG = "DebugPhaseListener";

	/** called when a phase is being started */
	@Override
	public void beforePhase(PhaseEvent evt) {
		System.out.println(PROG + " starting: " + evt.getPhaseId());	
	}
	
	/** Called when a phase is ending */
	@Override
	public void afterPhase(PhaseEvent evt) {
		// System.out.println(PROG + " ending:   " + evt.getPhaseId());	
	}

	/** Called to find out what phaseId's we are interested in */
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
