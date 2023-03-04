package ch.rewiso.archunit.rules;

import ch.rewiso.archunit.configuration.ConfigurationHolder;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.context.annotation.Configuration;

import static ch.rewiso.archunit.configuration.ConfigurationDefaults.CONFIGURATION_NAME;
import static ch.rewiso.archunit.configuration.ConfigurationDefaults.CONFIGURATION_PACKAGE;

public class ConfigurationRules {

    @ArchTest
    public static final ArchRule configurationClassesShouldBeAnnotatedWithConfigurationAnnotation =
            ArchRuleDefinition.classes()
                    .that().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getConfigurationName())
                    .should().beAnnotatedWith(Configuration.class)
                    .allowEmptyShould(true);


    @ArchTest
    public static final ArchRule configurationClassesShouldBeAnnotatedWithConfigurationAnnotation1 =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Configuration.class)
                    .should().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getConfigurationName())
                    .allowEmptyShould(true);


    @ArchTest
    public static final ArchRule noClassesWithConfigurationAnnotationShouldResideOutsideOfAdaptersLayerPackages =
            ArchRuleDefinition.noClasses()
                    .that().areAnnotatedWith(Configuration.class)
                    .should().resideOutsideOfPackage(ConfigurationHolder.getConfiguration().getConfigurationPackage())
                    .allowEmptyShould(true);


}
