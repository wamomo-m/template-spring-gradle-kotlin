plugins {
    id("shared.spring-kotlin-base")
    id("shared.test-task-base")
    id("org.springframework.boot")
}

version = "1.0.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}
