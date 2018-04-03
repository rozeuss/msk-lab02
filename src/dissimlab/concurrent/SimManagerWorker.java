package dissimlab.concurrent;

import dissimlab.simcore.SimManager;

public class SimManagerWorker implements Runnable {

    private String configuration;
    private SimManager simManager;

    public SimManagerWorker(String s) {
        this.configuration = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Configuration = " + configuration);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.configuration;
    }
}
