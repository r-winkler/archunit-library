package ch.rewiso.archunit.rules.spring_coding_rules.spring_field_dependency_injection_should_not_be_used;

import ch.rewiso.archunit.rules.SpringCodingRules;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class SpringFieldDependencyInjectionShouldNotBeUsedTest {
    static final String NO_FIELDS_SHOULD_BE_ANNOTATED_WITH_AUTOWIRED = "no fields should be annotated with @Autowired";
    ClassFileImporter classFileImporter = new ClassFileImporter();
    ArchRule rule = SpringCodingRules.springFieldDependencyInjectionShouldNotBeUsed;


    @Test
    void non_compliant() {

        var cut = NonCompliant.class;

        assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                .isInstanceOf(AssertionError.class)
                .hasMessageContaining(NO_FIELDS_SHOULD_BE_ANNOTATED_WITH_AUTOWIRED);

    }


    @Test
    void compliant() {

        var cut = Compliant.class;

        assertThatNoException().isThrownBy(() -> rule.check(classFileImporter.importClasses(cut)));
    }


    @Component
    class NonCompliant {

        @Autowired
        private final String str = null;

    }


    @Component
    class Compliant {

        private final String str;

        Compliant(String str) {
            this.str = str;
        }
    }

}
