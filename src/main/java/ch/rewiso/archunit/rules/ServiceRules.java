package ch.rewiso.archunit.rules;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Service;

import static ch.rewiso.archunit.configuration.Constants.*;

public class ServiceRules {

    @ArchTest
    public static final ArchRule serviceClassesShouldHaveNameEndingWithService =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().haveSimpleNameEndingWith(SERVICE_NAME);

    @ArchTest
    public static final ArchRule serviceClassesShouldBeAnnotatedWithServiceAnnotation =
            ArchRuleDefinition.classes()
                    .that().haveSimpleNameEndingWith(SERVICE_NAME)
                    .should().beAnnotatedWith(Service.class);

    @ArchTest
    public static final ArchRule serviceClassesShouldOnlyBeAccessedByController =
            ArchRuleDefinition.classes()
                    .that().resideInAPackage(SERVICE_PACKAGE)
                    .should().onlyBeAccessed().byAnyPackage(SERVICE_PACKAGE, CONTROLLER_PACKAGE);


}
