package ch.rewiso.archunit.rules;

import ch.rewiso.archunit.configuration.ConfigurationHolder;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Repository;

public class RepositoryRules {

    @ArchTest
    public static final ArchRule repositoryClassesShouldHaveNameEndingWithRepository =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Repository.class)
                    .should().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getRepositoryName())
                    .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule repositoryClassesShouldBeAnnotatedWithRepositoryAnnotation =
            ArchRuleDefinition.classes()
                    .that().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getRepositoryName())
                    .and().areNotInterfaces()
                    .should().beAnnotatedWith(Repository.class)
                    .allowEmptyShould(true);


    @ArchTest
    public static final ArchRule noClassesWithRepositoryAnnotationShouldResideOutsideOfRepositoryPackage =
            ArchRuleDefinition.noClasses()
                    .that().areAnnotatedWith(Repository.class)
                    .should().resideOutsideOfPackage(ConfigurationHolder.getConfiguration().getRepositoryPackage())
                    .allowEmptyShould(true);

}
