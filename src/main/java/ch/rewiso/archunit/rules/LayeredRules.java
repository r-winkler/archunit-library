package ch.rewiso.archunit.rules;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

import static ch.rewiso.archunit.configuration.Constants.*;

public class LayeredRules {

    @ArchTest
    public static final ArchRule layeredArchitectureShouldBeRespected =
            Architectures.layeredArchitecture()
                    .consideringAllDependencies()
                    .layer("Controller").definedBy(CONTROLLER_PACKAGE)
                    .layer("Service").definedBy(SERVICE_PACKAGE)
                    .layer("Repository").definedBy(REPOSITORY_PACKAGE)
                    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                    .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

}
