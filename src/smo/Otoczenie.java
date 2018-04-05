package smo;

import dissimlab.broker.INotificationEvent;
import dissimlab.broker.IPublisher;
import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;
import dissimlab.simcore.SimManager;


public class Otoczenie extends BasicSimObj {
    public Zglaszaj zglaszaj;
    public Smo smo;

    public Otoczenie(Smo smo, SimManager simManager) throws SimControlException {
        // Powołanie instancji pierwszego zdarzenia
		super(simManager);
		this.smo = smo;
		zglaszaj = new Zglaszaj(this, 0.0,simManager );
		// SMO dla zgłoszeń
	}

	@Override
	public void reflect(IPublisher publisher, INotificationEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean filter(IPublisher publisher, INotificationEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public Smo getSmo() {
		return smo;
	}
}
