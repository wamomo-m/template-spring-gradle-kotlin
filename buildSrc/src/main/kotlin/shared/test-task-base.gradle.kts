package shared

plugins {
    java
    `jvm-test-suite`
    jacoco
}

testing.suites.named<JvmTestSuite>("test") {
    useJUnitJupiter()

    val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-test")
        implementation(versionCatalog.findLibrary("kotest-runner-junit5").get())
        implementation(versionCatalog.findLibrary("mockk").get())
        implementation(versionCatalog.findLibrary("archunit-junit5").get())
    }
}

tasks.test{
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}
