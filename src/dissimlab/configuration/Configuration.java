package dissimlab.configuration;

public class Configuration {
    private double seed;

    public Configuration(double seed) {
        this.seed = seed;
    }

    public double getSeed() {
        return seed;
    }

    public void setSeed(double seed) {
        this.seed = seed;
    }

    @Override
    public String toString() {
        return "Configuration{" +
            "seed=" + seed +
            '}';
    }
}
