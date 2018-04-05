package smo;

/**
 * @author Dariusz Pierzchala
 * <p>
 * Description: Klasa główna. Tworzy dwa SMO, inicjalizuje je.Startuje symulację. Wyświetla statystyki.
 * <p>
 * Wersja testowa.
 */

import dissimlab.simcore.SimControlEvent;
import dissimlab.simcore.SimControlException;
import dissimlab.simcore.SimManager;
import dissimlab.simcore.SimParameters.SimControlStatus;

public class AppSMO implements Runnable {
    private long seed;

    public AppSMO(long seed) {
        this.seed = seed;
    }

    public void run() {
        try {

//            SimManager model = SimManager.getInstance();
            SimManager model = new SimManager();
            // Powołanie Smo
            Smo smo = new Smo(model, seed);
            // Utworzenie otoczenia
            Otoczenie generatorZgl = new Otoczenie(smo, model);
            // Dwa sposoby zaplanowanego końca symulacji
            //model.setEndSimTime(10000);
            // lub
            SimControlEvent stopEvent = new SimControlEvent(1000.0, SimControlStatus.STOPSIMULATION, model);
            // Uruchomienie symulacji za pośrednictwem metody "startSimulation"
            model.startSimulation();

        } catch (SimControlException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
