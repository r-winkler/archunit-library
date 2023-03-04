package ch.rewiso.archunit.rules.spring_coding_rules.spring_singleton_components_should_only_have_final_fields;

import ch.rewiso.archunit.rules.SpringCodingRules;
import ch.rewiso.archunit.rules.spring_coding_rules.spring_singleton_components_should_only_have_final_fields.test_classes.compliant.*;
import ch.rewiso.archunit.rules.spring_coding_rules.spring_singleton_components_should_only_have_final_fields.test_classes.non_compliant.*;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class SpringSingletonComponentsShouldOnlyHaveFinalFieldsTest {

    public static final String IS_NOT_FINAL = "is not final";
    ClassFileImporter classFileImporter = new ClassFileImporter();

    ArchRule rule = SpringCodingRules.springSingletonComponentsShouldOnlyHaveFinalFields;

    @Nested
    class non_compliant {

        @Test
        void component() {

            var cut = ComponentNonCompliant.class;

            assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                    .isInstanceOf(AssertionError.class)
                    .hasMessageContaining(IS_NOT_FINAL);

        }

        @Test
        void service() {

            var cut = ServiceNonCompliant.class;

            assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                    .isInstanceOf(AssertionError.class)
                    .hasMessageContaining(IS_NOT_FINAL);

        }


        @Test
        void controller() {

            var cut = ControllerNonCompliant.class;

            assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                    .isInstanceOf(AssertionError.class)
                    .hasMessageContaining(IS_NOT_FINAL);

        }


        @Test
        void restController() {

            var cut = RestControllerNonCompliant.class;

            assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                    .isInstanceOf(AssertionError.class)
                    .hasMessageContaining(IS_NOT_FINAL);

        }

        @Test
        void repository() {

            var cut = RespositoryNonCompliant.class;

            assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                    .isInstanceOf(AssertionError.class)
                    .hasMessageContaining(IS_NOT_FINAL);

        }
    }

    @Nested
    class compliant {

        @Test
        void component() {

            var cut = ComponentCompliant.class;

            assertThatNoException().isThrownBy(() -> rule.check(classFileImporter.importClasses(cut)));
        }

        @Test
        void componentWithConfigurationProperties() {

            var cut = ComponentWithConfigurationPropertiesCompliant.class;

            assertThatThrownBy(() -> rule.check(classFileImporter.importClasses(cut)))
                    .isInstanceOf(AssertionError.class)
                    .hasMessageContaining("failed to check any classes"); // rule does not apply here
        }


        @Test
        void service() {

            var cut = ServiceCompliant.class;

            assertThatNoException().isThrownBy(() -> rule.check(classFileImporter.importClasses(cut)));
        }


        @Test
        void controller() {

            var cut = ControllerCompliant.class;

            assertThatNoException().isThrownBy(() -> rule.check(classFileImporter.importClasses(cut)));
        }


        @Test
        void restController() {

            var cut = RestControllerCompliant.class;

            assertThatNoException().isThrownBy(() -> rule.check(classFileImporter.importClasses(cut)));
        }


        @Test
        void repository() {

            var cut = RepositoryCompliant.class;

            assertThatNoException().isThrownBy(() -> rule.check(classFileImporter.importClasses(cut)));
        }
    }

}
