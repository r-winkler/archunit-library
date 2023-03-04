
# Maven dependency
```
<dependency>
    <groupId>ch.rewiso</groupId>
    <artifactId>archunit-library</artifactId>
    <version>${archunit-library.version}</version>
    <scope>test</scope>
</dependency>
```

# Usage

Execute all rules
```
@AnalyzeClasses(packages = "package.to.be.scanned")
public class ArchUnitTest {

    @ArchTest
    static final ArchTests springCodingRules = ArchTests.in(SpringCodingRules.class);

}
```

Execute some rules
```
@AnalyzeClasses(packages = "ch.rewiso")
public class ArchUnitTest {

    @ArchTest
    static final ArchRule springSingletonComponentsShouldOnlyHaveFinalFields = SpringCodingRules.springSingletonComponentsShouldOnlyHaveFinalFields;
    @ArchTest
    static final ArchRule springFieldDependencyInjectionShouldNotBeUsed = SpringCodingRules.springFieldDependencyInjectionShouldNotBeUsed;

}
```
