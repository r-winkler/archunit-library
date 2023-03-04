package ch.rewiso.archunit.rules;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


public class SpringCodingRules {

    @ArchTest
    public static final ArchRule springSingletonComponentsShouldOnlyHaveFinalFields =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Service.class)
                    .or().areAnnotatedWith(Component.class).and().areNotAnnotatedWith(ConfigurationProperties.class)
                    .or().areAnnotatedWith(Controller.class)
                    .or().areAnnotatedWith(RestController.class)
                    .or().areAnnotatedWith(Repository.class)
                    .should().haveOnlyFinalFields();

    @ArchTest
    public static final ArchRule springFieldDependencyInjectionShouldNotBeUsed =
            ArchRuleDefinition.noFields()
                    .should().beAnnotatedWith(Autowired.class);


}