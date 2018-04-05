package dissimlab.configuration;

public class Configuration {
    private long seed;

    public Configuration(long seed) {
        this.seed = seed;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    @Override
    public String toString() {
        return "Configuration{" +
            "seed=" + seed +
            '}';
    }
}
