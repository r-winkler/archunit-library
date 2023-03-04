package ch.rewiso.archunit.rules;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Repository;

import static ch.rewiso.archunit.configuration.Constants.REPOSITORY_NAME;
import static ch.rewiso.archunit.configuration.Constants.REPOSITORY_PACKAGE;

public class RepositoryRules {

    @ArchTest
    public static final ArchRule repositoryClassesShouldHaveNameEndingWithRepository =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Repository.class)
                    .should().haveSimpleNameEndingWith(REPOSITORY_NAME);

    @ArchTest
    public static final ArchRule repositoryClassesShouldBeAnnotatedWithRepositoryAnnotation =
            ArchRuleDefinition.classes()
                    .that().haveSimpleNameEndingWith(REPOSITORY_NAME)
                    .and().areNotInterfaces()
                    .should().beAnnotatedWith(Repository.class);


    @ArchTest
    public static final ArchRule noClassesWithRepositoryAnnotationShouldResideOutsideOfRepositoryPackage =
            ArchRuleDefinition.noClasses()
                    .that().areAnnotatedWith(Repository.class)
                    .should().resideOutsideOfPackage(REPOSITORY_PACKAGE);

}
