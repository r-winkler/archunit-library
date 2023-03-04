package ch.rewiso.archunit.configuration;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class Configuration {

    private String controllerPackage = ConfigurationDefaults.CONTROLLER_PACKAGE;
    private String controllerName = ConfigurationDefaults.CONTROLLER_NAME;
    private String servicePackage = ConfigurationDefaults.SERVICE_PACKAGE;
    private String serviceName = ConfigurationDefaults.SERVICE_NAME;

    private String repositoryPackage = ConfigurationDefaults.REPOSITORY_PACKAGE;
    private String repositoryName = ConfigurationDefaults.REPOSITORY_NAME;

    private String configurationPackage = ConfigurationDefaults.CONFIGURATION_PACKAGE;

    private String configurationName = ConfigurationDefaults.CONFIGURATION_NAME;


    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getRepositoryPackage() {
        return repositoryPackage;
    }

    public void setRepositoryPackage(String repositoryPackage) {
        this.repositoryPackage = repositoryPackage;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getConfigurationPackage() {
        return configurationPackage;
    }

    public void setConfigurationPackage(String configurationPackage) {
        this.configurationPackage = configurationPackage;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("controllerPackage", controllerPackage)
                .append("controllerName", controllerName)
                .append("servicePackage", servicePackage)
                .append("serviceName", serviceName)
                .append("repositoryPackage", repositoryPackage)
                .append("repositoryName", repositoryName)
                .append("configurationPackage", configurationPackage)
                .append("configurationName", configurationName)
                .toString();
    }
}
