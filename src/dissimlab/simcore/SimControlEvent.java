package dissimlab.simcore;

import dissimlab.simcore.SimParameters.SimControlStatus;

/**
 * Description...
 * 
 * @author Dariusz Pierzchala
 *
 */
public class SimControlEvent extends BasicSimEvent<BasicSimObj, SimControlStatus> {

	public SimControlEvent(double delay, SimControlStatus status, int priority, SimManager simManager) throws SimControlException {
		super(delay, status, priority, simManager);
 	}

	public SimControlEvent(double delay, SimControlStatus status, SimManager simManager) throws SimControlException {
		super(delay, status, simManager );
 	}

	@Override
	protected void onInterruption() {		
	}

	@Override
	protected void onTermination() {	
	}

	@Override
	protected void stateChange() {
		switch (this.transitionParams) {
		case STARTSIMULATION:
			//Removed in the limited version							
			break;

		case STOPSIMULATION:
			getSimObj().proceedStopSimulation();			
			break;

		case PAUSESIMULATION:
			getSimObj().proceedPauseSimulation();							
			break;

		case RESUMESIMULATION:
			//Removed in the limited version							
			break;

		case RESTARTSIMULATION:
			//Removed in the limited version							
			break;

		case SAVESIMULATION:
			//Removed in the limited version							
			break;

		default:
			break;
		}
	}

	@Override
	public Object getEventParams() {
		return (SimControlStatus) transitionParams;
	}

}
