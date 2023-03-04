package ch.rewiso.archunit.rules;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.context.annotation.Configuration;

import static ch.rewiso.archunit.configuration.Constants.CONFIGURATION_NAME;
import static ch.rewiso.archunit.configuration.Constants.CONFIGURATION_PACKAGE;

public class ConfigurationRules {

    @ArchTest
    public static final ArchRule configurationClassesShouldBeAnnotatedWithConfigurationAnnotation =
            ArchRuleDefinition.classes()
                    .that().haveSimpleNameEndingWith(CONFIGURATION_NAME)
                    .should().beAnnotatedWith(Configuration.class);


    @ArchTest
    public static final ArchRule configurationClassesShouldBeAnnotatedWithConfigurationAnnotation1 =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Configuration.class)
                    .should().haveSimpleNameEndingWith(CONFIGURATION_NAME);


    @ArchTest
    public static final ArchRule noClassesWithConfigurationAnnotationShouldResideOutsideOfAdaptersLayerPackages =
            ArchRuleDefinition.noClasses()
                    .that().areAnnotatedWith(Configuration.class)
                    .should().resideOutsideOfPackage(CONFIGURATION_PACKAGE);


}
