package ch.rewiso.archunit.rules.spring_coding_rules.spring_singleton_components_should_only_have_final_fields.test_classes.non_compliant;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerNonCompliant {

    private String str = "";
}
