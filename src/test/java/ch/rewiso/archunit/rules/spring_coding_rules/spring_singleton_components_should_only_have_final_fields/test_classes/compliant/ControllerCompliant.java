package ch.rewiso.archunit.rules.spring_coding_rules.spring_singleton_components_should_only_have_final_fields.test_classes.compliant;

import org.springframework.stereotype.Controller;

@Controller
public class ControllerCompliant {

    private final String str = "";
}
