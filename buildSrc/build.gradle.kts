plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.allopen)
    implementation(libs.spring.boot.gradle.plugin)
    implementation(libs.ktlint.gradle)
    implementation(libs.gradle.docker.compose.plugin)
}
