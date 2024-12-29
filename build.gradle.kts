plugins {
    id("java-library")
    id("maven-publish")
}

group = "com.github.VKabz" // Укажите ваш GitHub-логин в группе для совместимости с JitPack
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "civilization-api" // Укажите имя артефакта для публикации
        }
    }
    repositories {
        maven {
            // Оставьте JitPack пустым, так как он автоматически обрабатывает публикацию
            // Если нужен другой репозиторий, укажите его URL:
            // url = uri("https://repo.yourserver.com/releases")
        }
    }
}
