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
        testing {
            dependencies {}
        }
        implementation(versionCatalog.findLibrary("spring-boot-starter-test").get())
    }
}

tasks.test{
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}
