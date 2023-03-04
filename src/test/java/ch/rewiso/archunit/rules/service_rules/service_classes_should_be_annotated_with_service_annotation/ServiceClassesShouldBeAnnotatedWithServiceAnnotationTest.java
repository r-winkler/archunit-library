package ch.rewiso.archunit.rules.service_rules.service_classes_should_be_annotated_with_service_annotation;

import ch.rewiso.archunit.rules.ServiceRules;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ServiceClassesShouldBeAnnotatedWithServiceAnnotationTest {

    public static final String HAVE_SIMPLE_NAME_ENDING_WITH_SERVICE_SHOULD_BE_ANNOTATED_WITH_SERVICE = "have simple name ending with 'Service' should be annotated with @Service";
    ClassFileImporter classFileImporter = new ClassFileImporter();
    ArchRule rule = ServiceRules.serviceClassesShouldBeAnnotatedWithServiceAnnotation;


    @Test
    void non_compliant() {

        var cut = NonCompliantService.class;

        assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                .isInstanceOf(AssertionError.class)
                .hasMessageContaining(HAVE_SIMPLE_NAME_ENDING_WITH_SERVICE_SHOULD_BE_ANNOTATED_WITH_SERVICE);

    }


    @Test
    void compliant() {

        var cut = CompliantService.class;

        assertThatNoException().isThrownBy(() -> rule.check(classFileImporter.importClasses(cut)));

    }


    class NonCompliantService {


    }

    @Service
    class CompliantService {

    }


}
