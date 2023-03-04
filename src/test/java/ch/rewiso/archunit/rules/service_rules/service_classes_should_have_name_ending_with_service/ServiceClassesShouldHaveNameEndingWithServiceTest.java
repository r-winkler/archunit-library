package ch.rewiso.archunit.rules.service_rules.service_classes_should_have_name_ending_with_service;

import ch.rewiso.archunit.rules.ServiceRules;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ServiceClassesShouldHaveNameEndingWithServiceTest {

    public static final String SHOULD_HAVE_SIMPLE_NAME_ENDING_WITH_SERVICE = "should have simple name ending with 'Service'";
    ClassFileImporter classFileImporter = new ClassFileImporter();
    ArchRule rule = ServiceRules.serviceClassesShouldHaveNameEndingWithService;


    @Test
    void non_compliant() {

        var cut = NonCompliant.class;

        assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                .isInstanceOf(AssertionError.class)
                .hasMessageContaining(SHOULD_HAVE_SIMPLE_NAME_ENDING_WITH_SERVICE);

    }


    @Test
    void compliant() {

        var cut = CompliantService.class;

        assertThatNoException().isThrownBy(() -> rule.check(classFileImporter.importClasses(cut)));

    }


    @Service
    class NonCompliant {


    }

    @Service
    class CompliantService {

    }


}
