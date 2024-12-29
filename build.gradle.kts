plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("java-library")
    id("maven-publish")
}

group = "com.github.VKabz"
version = "1.0.1"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // Для Spigot API
    maven("https://oss.sonatype.org/content/repositories/snapshots/") // Для Paper API (опционально)
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT") // Замените версию на вашу
    implementation(kotlin("stdlib")) // Подключение стандартной библиотеки Kotlin
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output) // Включаем скомпилированный код в JAR
    manifest {
        attributes(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version
        )
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
