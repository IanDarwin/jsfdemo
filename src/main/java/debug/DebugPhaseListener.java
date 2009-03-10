package debug;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class DebugPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 3303149225999676320L;
	private static final String PROG = "DebugPhaseListener";

	/** called when a phase is being started */
	public void beforePhase(PhaseEvent evt) {
		System.out.println(PROG + " starting: " + evt.getPhaseId());	
	}
	
	/** Called when a phase is ending */
	public void afterPhase(PhaseEvent evt) {
		System.out.println(PROG + " ending:   " + evt.getPhaseId());	
	}

	/** Called to find out what phaseId's we are interested in */
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
