plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val seleniumVersion: String = findProperty("seleniumVersion") as String
val selenideVersion: String = findProperty("selenideVersion") as String
val allureSelenideVersion: String = findProperty("allureSelenideVersion") as String

dependencies {
    testImplementation(project(":"))
    testImplementation(project(":api-tests"))
    testImplementation("com.codeborne:selenide:$selenideVersion")
    testImplementation("org.testcontainers:selenium:$seleniumVersion")
    testImplementation("io.qameta.allure:allure-selenide:$allureSelenideVersion")
}

tasks.test {
    useJUnitPlatform()
}
