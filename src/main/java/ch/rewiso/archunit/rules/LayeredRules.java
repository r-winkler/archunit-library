package ch.rewiso.archunit.rules;

import ch.rewiso.archunit.configuration.ConfigurationHolder;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

import static ch.rewiso.archunit.configuration.ConfigurationDefaults.*;

public class LayeredRules {

    @ArchTest
    public static final ArchRule layeredArchitectureShouldBeRespected =
            Architectures.layeredArchitecture()
                    .consideringAllDependencies()
                    .layer("Controller").definedBy(ConfigurationHolder.getConfiguration().getControllerPackage())
                    .layer("Service").definedBy(ConfigurationHolder.getConfiguration().getServicePackage())
                    .layer("Repository").definedBy(ConfigurationHolder.getConfiguration().getRepositoryPackage())
                    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                    .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

}
