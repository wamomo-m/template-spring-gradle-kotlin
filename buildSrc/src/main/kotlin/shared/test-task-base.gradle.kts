package shared

plugins {
    java
    `jvm-test-suite`
    jacoco
}

testing.suites.named<JvmTestSuite>("test") {
    useJUnitJupiter()

    dependencies {
        testing {
            dependencies {}
        }
        implementation("org.springframework.boot:spring-boot-starter-test:3.1.2")
    }
}

tasks.test{
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}
