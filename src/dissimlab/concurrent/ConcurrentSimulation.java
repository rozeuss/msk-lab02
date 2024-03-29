package dissimlab.concurrent;

import dissimlab.configuration.Series;
import dissimlab.configuration.reader.ConfigurationReader;
import dissimlab.simcore.SimManager;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentSimulation {

    public static void main(String[] args) {
        ConfigurationReader configurationReader = new ConfigurationReader();
        configurationReader.readConfiguration();
        Series series = configurationReader.getSeries();
        ExecutorService executor = Executors.newFixedThreadPool(series.getNumberOfThreads());
        for (int i = 0; i < series.getConfigs().size(); i++) {
            Runnable worker = new SimManagerWorker("" + (i + 1), series.getConfigs().get(i));
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
