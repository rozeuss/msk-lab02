package dissimlab.concurrent;

import dissimlab.configuration.Configuration;
import dissimlab.simcore.SimManager;
import smo.AppSMO;

public class SimManagerWorker implements Runnable {

    private String configurationName;
    private SimManager simManager;
    private Configuration configuration;


    public SimManagerWorker(String s, Configuration configuration) {
        this.configurationName = s;
        this.configuration = configuration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Configuration = " + configurationName);
        System.out.println("SEED: " + configuration.getSeed());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        AppSMO appSMO = new AppSMO(configuration.getSeed());
        appSMO.run();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public String toString() {
        return this.configurationName;
    }
}
