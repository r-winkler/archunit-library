package ch.rewiso.archunit.rules;

import ch.rewiso.archunit.configuration.ConfigurationHolder;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Service;

import static ch.rewiso.archunit.configuration.ConfigurationDefaults.*;

public class ServiceRules {

    @ArchTest
    public static final ArchRule serviceClassesShouldHaveNameEndingWithService =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getServiceName())
                    .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule serviceClassesShouldBeAnnotatedWithServiceAnnotation =
            ArchRuleDefinition.classes()
                    .that().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getServiceName())
                    .should().beAnnotatedWith(Service.class)
                    .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule serviceClassesShouldOnlyBeAccessedByController =
            ArchRuleDefinition.classes()
                    .that().resideInAPackage(ConfigurationHolder.getConfiguration().getServicePackage())
                    .should().onlyBeAccessed().byAnyPackage(ConfigurationHolder.getConfiguration().getServicePackage(), ConfigurationHolder.getConfiguration().getControllerPackage())
                    .allowEmptyShould(true);


}
