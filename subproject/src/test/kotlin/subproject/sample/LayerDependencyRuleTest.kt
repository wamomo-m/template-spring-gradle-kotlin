package subproject.sample

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(
    packages = ["subproject.sample"],
    importOptions = [ImportOption.DoNotIncludeTests::class]
)
class LayerDependencyRuleTest {
    @ArchTest
    val layeredTest: ArchRule = Architectures.layeredArchitecture()
        .consideringAllDependencies()
        .apply {
            layer("Application").definedBy("subproject.sample")
        }
        .apply {
            // Application はどこからも参照されない
            whereLayer("Application").mayNotBeAccessedByAnyLayer()
        }
}
