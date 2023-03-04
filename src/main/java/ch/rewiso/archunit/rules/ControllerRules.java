package ch.rewiso.archunit.rules;

import ch.rewiso.archunit.configuration.ConfigurationHolder;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class ControllerRules {

    @ArchTest
    public static final ArchRule controllerClassesShouldHaveNameEndingWithController =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Controller.class)
                    .or().areAnnotatedWith(RestController.class)
                    .should().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getControllerName())
                    .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule controllerClassesShouldBeAnnotatedWithControllerOrRestControllerAnnotation =
            ArchRuleDefinition.classes()
                    .that().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getControllerName())
                    .should().beAnnotatedWith(Controller.class)
                    .orShould().beAnnotatedWith(RestController.class)
                    .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule noClassesWithControllerOrRestControllerAnnotationShouldResideOutsideOfControllerPackage =
            ArchRuleDefinition.noClasses()
                    .that().areAnnotatedWith(Controller.class)
                    .or().areAnnotatedWith(RestController.class)
                    .should().resideOutsideOfPackage(ConfigurationHolder.getConfiguration().getControllerPackage())
                    .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule controllerClassesShouldNotDependOnEachOther =
            ArchRuleDefinition.noClasses()
                    .that().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getControllerName())
                    .should().dependOnClassesThat().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getControllerName())
                    .allowEmptyShould(true);

    @ArchTest
    public static final ArchRule publicControllerMethodsShouldBeAnnotatedWithARequestMapping =
            ArchRuleDefinition.methods()
                    .that().arePublic()
                    .and().areDeclaredInClassesThat().resideInAPackage(ConfigurationHolder.getConfiguration().getControllerPackage())
                    .and().areDeclaredInClassesThat().haveSimpleNameEndingWith(ConfigurationHolder.getConfiguration().getControllerName())
                    .and().areDeclaredInClassesThat().areAnnotatedWith(Controller.class)
                    .or().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
                    .should().beAnnotatedWith(RequestMapping.class)
                    .orShould().beAnnotatedWith(GetMapping.class)
                    .orShould().beAnnotatedWith(PostMapping.class)
                    .orShould().beAnnotatedWith(PatchMapping.class)
                    .orShould().beAnnotatedWith(DeleteMapping.class)
                    .allowEmptyShould(true);


    @ArchTest
    public static final ArchRule controllerMethodShouldBeSecuredWithPreAuthorize =
            ArchRuleDefinition.methods()
                    .that().arePublic()
                    .and().areDeclaredInClassesThat().resideInAPackage(ConfigurationHolder.getConfiguration().getControllerPackage())
                    .should().beAnnotatedWith(PreAuthorize.class);

}
