package dissimlab.configuration;

import java.util.List;

public class Series {
    private int numberOfThreads;
    private List<Configuration> configs;

    public Series(int numberOfThreads, List<Configuration> configs) {
        this.numberOfThreads = numberOfThreads;
        this.configs = configs;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public List<Configuration> getConfigs() {
        return configs;
    }

    public void setConfigs(List<Configuration> configs) {
        this.configs = configs;
    }

    @Override
    public String toString() {
        return "Series{" +
                "numberOfThreads=" + numberOfThreads +
                ", configs=" + configs +
                '}';
    }
}
