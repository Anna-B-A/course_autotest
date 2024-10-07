plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitJupiterVersion: String = findProperty("junitJupiterVersion") as String
val allureJunitVersion: String = findProperty("allureJunitVersion") as String


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
    testImplementation("io.qameta.allure:allure-junit5:$allureJunitVersion")
}

subprojects {
    apply(plugin = "java")

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
        testImplementation("io.qameta.allure:allure-junit5:$allureJunitVersion")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("runApiTests") {
    dependsOn(":api-tests:test")
}

tasks.register("runUiTests") {
    dependsOn(":ui-tests:test")
}

tasks.register<Test>("runSmokeTests") {
    useJUnitPlatform{
        includeTags("smoke")
    }
}

//tasks.register<Test>("runHw_26_09") {
//    useJUnitPlatform()
//    val testClassName = "hw_26_09.NineTask"
//    filter {
//        includeTestsMatching(testClassName)
//    }
//}
