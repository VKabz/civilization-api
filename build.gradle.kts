plugins {
    id("java-library")
    id("maven-publish")
}

group = "ru.vkabz.civilization"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("https://repo.yourserver.com/releases") // Replace with your repository
        }
    }
}
