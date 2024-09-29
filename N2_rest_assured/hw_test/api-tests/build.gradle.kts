plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val restAssuredVersion: String = findProperty("restAssuredVersion") as String
val allureRestAssuredVersion: String = findProperty("allureRestAssuredVersion") as String
val jacksonVersion: String = findProperty("jacksonVersion") as String
val lombok: String = findProperty("lombok") as String
val jsonSchemaValidator: String = findProperty("jsonSchemaValidator") as String

dependencies {
    testImplementation("io.rest-assured:rest-assured:$restAssuredVersion")
    testImplementation("io.qameta.allure:allure-rest-assured:$allureRestAssuredVersion")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    testImplementation("org.projectlombok:lombok:$lombok")
    testImplementation("io.rest-assured:json-schema-validator:$jsonSchemaValidator")
}

tasks.test {
    useJUnitPlatform()
}
