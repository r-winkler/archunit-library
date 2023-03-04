package ch.rewiso.archunit.rules;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static ch.rewiso.archunit.configuration.Constants.CONTROLLER_NAME;
import static ch.rewiso.archunit.configuration.Constants.CONTROLLER_PACKAGE;

public class ControllerRules {

    @ArchTest
    public static final ArchRule controllerClassesShouldHaveNameEndingWithController =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Controller.class)
                    .or().areAnnotatedWith(RestController.class)
                    .should().haveSimpleNameEndingWith(CONTROLLER_NAME);

    @ArchTest
    public static final ArchRule controllerClassesShouldBeAnnotatedWithControllerOrRestControllerAnnotation =
        ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith(CONTROLLER_NAME)
                .should().beAnnotatedWith(Controller.class)
                .orShould().beAnnotatedWith(RestController.class);

    @ArchTest
    public static final ArchRule noClassesWithControllerOrRestControllerAnnotationShouldResideOutsideOfControllerPackage =
        ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Controller.class)
                .or().areAnnotatedWith(RestController.class)
                .should().resideOutsideOfPackage(CONTROLLER_PACKAGE);

    @ArchTest
    public static final ArchRule controllerClassesShouldNotDependOnEachOther =
        ArchRuleDefinition.noClasses()
                .that().haveSimpleNameEndingWith(CONTROLLER_NAME)
                .should().dependOnClassesThat().haveSimpleNameEndingWith(CONTROLLER_NAME);

    @ArchTest
    public static final ArchRule publicControllerMethodsShouldBeAnnotatedWithARequestMapping =
        ArchRuleDefinition.methods()
                .that().arePublic()
                .and().areDeclaredInClassesThat().resideInAPackage(CONTROLLER_PACKAGE)
                .and().areDeclaredInClassesThat().haveSimpleNameEndingWith(CONTROLLER_NAME)
                .and().areDeclaredInClassesThat().areAnnotatedWith(Controller.class)
                .or().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
                .should().beAnnotatedWith(RequestMapping.class)
                .orShould().beAnnotatedWith(GetMapping.class)
                .orShould().beAnnotatedWith(PostMapping.class)
                .orShould().beAnnotatedWith(PatchMapping.class)
                .orShould().beAnnotatedWith(DeleteMapping.class);

}
