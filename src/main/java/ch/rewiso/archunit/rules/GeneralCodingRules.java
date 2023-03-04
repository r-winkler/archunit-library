package ch.rewiso.archunit.rules;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

public class GeneralCodingRules {

    @ArchTest
    public static final ArchRule noClassesShouldUseStandardStreams =
            ArchRuleDefinition.noClasses()
                    .should(com.tngtech.archunit.library.GeneralCodingRules.ACCESS_STANDARD_STREAMS);

    @ArchTest
    public static final ArchRule noClassesShouldThrowGenericExceptions =
            ArchRuleDefinition.noClasses()
                    .should(com.tngtech.archunit.library.GeneralCodingRules.THROW_GENERIC_EXCEPTIONS);


    @ArchTest
    public static final ArchRule noClassesShouldUseStandardLogging =
            ArchRuleDefinition.noClasses()
                    .should(com.tngtech.archunit.library.GeneralCodingRules.USE_JAVA_UTIL_LOGGING);

}
