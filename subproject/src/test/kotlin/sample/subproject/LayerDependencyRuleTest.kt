package sample.subproject

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(
    packages = ["sample.subproject"],
    importOptions = [ImportOption.DoNotIncludeTests::class]
)
class LayerDependencyRuleTest {
    @ArchTest
    val layeredTest: ArchRule = Architectures.layeredArchitecture()
        .consideringAllDependencies()
        .apply {
            layer("Application").definedBy("sample.subproject")
        }
        .apply {
            // Application はどこからも参照されない
            whereLayer("Application").mayNotBeAccessedByAnyLayer()
        }
}
