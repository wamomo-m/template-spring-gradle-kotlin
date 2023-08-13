plugins {
    id("com.avast.gradle.docker-compose")
}

dockerCompose {
    setProjectName(rootProject.name)
}
