package dissimlab.configuration.reader;

public enum ElementType {
    SERIES,
    N_THREADS,
    CONFIG,
    SEED;

    public String camelCaseValue() {
        return toCamelCase(name());
    }

    static String toCamelCase(String s) {
        String[] parts = s.split("_");
        StringBuilder camelCaseStringBuilder = new StringBuilder();
        for (String part : parts) {
            camelCaseStringBuilder.append(toProperCase(part));
        }
        return camelCaseStringBuilder.toString().substring(0, 1).toLowerCase()
            + camelCaseStringBuilder.toString().substring(1);
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

}
