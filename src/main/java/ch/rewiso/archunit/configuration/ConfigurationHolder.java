package ch.rewiso.archunit.configuration;

public class ConfigurationHolder {

    private static Configuration configuration;

    static {
        try {
            var reader = new ConfigurationReader();
            var properties = reader.readProperties();

            var parser = new ConfigurationParser();
            configuration = parser.propertiesToConfiguration(properties);
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating ConfigurationHolder instance");
        }
    }

    private ConfigurationHolder() {

    }

    public static Configuration getConfiguration() {
        return configuration;
    }
}
