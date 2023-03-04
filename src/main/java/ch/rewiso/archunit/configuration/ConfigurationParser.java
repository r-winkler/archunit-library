package ch.rewiso.archunit.configuration;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

public class ConfigurationParser {

    public Configuration propertiesToConfiguration(Properties properties) {

        Configuration configuration = new Configuration();
        var controllerPackage = properties.getProperty("controller.package");
        var controllerName = properties.getProperty("controller.name");
        var servicePackage = properties.getProperty("service.package");
        var serviceName = properties.getProperty("service.name");
        var repositoryPackage = properties.getProperty("repository.package");
        var repositoryName = properties.getProperty("repository.name");
        var configurationPackage = properties.getProperty("configuration.package");
        var configurationName = properties.getProperty("configuration.name");

        if (StringUtils.isNotEmpty(controllerPackage)) {
            configuration.setControllerPackage(controllerPackage);
        }

        if (StringUtils.isNotEmpty(controllerName)) {
            configuration.setControllerPackage(controllerName);
        }

        if (StringUtils.isNotEmpty(servicePackage)) {
            configuration.setServicePackage(servicePackage);
        }

        if (StringUtils.isNotEmpty(serviceName)) {
            configuration.setServiceName(serviceName);
        }

        if (StringUtils.isNotEmpty(repositoryPackage)) {
            configuration.setRepositoryPackage(repositoryPackage);
        }

        if (StringUtils.isNotEmpty(repositoryName)) {
            configuration.setRepositoryName(repositoryName);
        }

        if (StringUtils.isNotEmpty(configurationPackage)) {
            configuration.setConfigurationPackage(configurationPackage);
        }

        if (StringUtils.isNotEmpty(configurationName)) {
            configuration.setConfigurationName(configurationName);
        }

        return configuration;

    }

}

