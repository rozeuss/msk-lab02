package smo;

import dissimlab.random.SimGenerator;
import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;
import dissimlab.simcore.SimManager;
import dissimlab.simcore.SimParameters.SimDateField;

/**
 * Description: Zdarzenie generatora zgłoszeń. Tworzy obiekt - zgłoszenie co losowy czas.
 * 
 * @author Dariusz Pierzchala

 */
public class Zglaszaj extends BasicSimEvent<Otoczenie, Object>
{
	private SimManager simManager;
	private SimGenerator generator;
    private Otoczenie parent;

    public Zglaszaj(Otoczenie parent, double delay, SimManager simManager) throws SimControlException
    {
		super(parent, delay);
		this.parent = parent;
		this.simManager = simManager;
    	generator = new SimGenerator(parent.getSmo().getSeed());
    }

    public Zglaszaj(Otoczenie parent) throws SimControlException
    {
    	super(parent);
    	generator = new SimGenerator();
    }
    
	@Override
	protected void onInterruption() throws SimControlException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onTermination() throws SimControlException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void stateChange() throws SimControlException {
        parent = getSimObj();
        Zgloszenie zgl = new Zgloszenie(simTime(), parent.smo, this.simManager);
        parent.smo.dodaj(zgl);
        System.out.println(simTime()+" - "+simDate(SimDateField.HOUR24)+" - "+simDate(SimDateField.MINUTE)+" - "+simDate(SimDateField.SECOND)+" - "+simDate(SimDateField.MILLISECOND)+": Otoczenie- Dodano nowe zgl. nr: " + zgl.getTenNr());
        // Aktywuj obsługę, jeżeli kolejka była pusta (gniazdo "spało")
        if (parent.smo.liczbaZgl()==1 && parent.smo.isWolne()) {
        	parent.smo.rozpocznijObsluge = new RozpocznijObsluge(parent.smo);
        }
        // Wygeneruj czas do kolejnego zgłoszenia
        double odstep = generator.normal(5.0, 1.0);
        setRepetitionPeriod(odstep);
        //alternatywnie: parent.zglaszaj = new Zglaszaj(parent, odstep);
	}

	@Override
	public Object getEventParams() {
		// TODO Auto-generated method stub
		return null;
	}
}