plugins {
    id("org.jetbrains.intellij") version "1.10.0"
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("maven-publish")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10") // Стандартная версия без привязки к JDK 17
    implementation(gradleApi())
    implementation(localGroovy())
}


    repositories {
        maven {
            url = uri("https://repo.maven.apache.org/maven2/")

        }
        mavenCentral() // Репозиторий для большинства зависимостей
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev") } // Репозиторий Kotlin
    }


intellij {
    version.set("2023.2")
    type.set("IC")
}

tasks {
    buildPlugin {
        dependsOn("patchPluginXml")
    }
}
