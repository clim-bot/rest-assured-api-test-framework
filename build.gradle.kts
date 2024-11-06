plugins {
    java
    id("io.qameta.allure") version "2.11.2"
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    // Rest Assured for API testing
    implementation("io.rest-assured:rest-assured:5.3.0")

    // TestNG for testing framework
    testImplementation("org.testng:testng:7.7.0")

    // Allure TestNG Adapter for reporting
    testImplementation("io.qameta.allure:allure-testng:2.20.1")

    // JWT for token management
    implementation("com.auth0:java-jwt:4.2.1")

    // Hamcrest for assertions
    testImplementation("org.hamcrest:hamcrest:2.2")

    // Jackson for JSON processing
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    // SLF4J API and Logback for logging
    implementation("org.slf4j:slf4j-api:1.7.36")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.11")
}


tasks.test {
    useTestNG()
    testLogging {
        events("passed", "failed", "skipped")
    }
}

tasks.withType<Test> {
    doFirst {
        delete("$buildDir/allure-results") // Ensures fresh results directory
    }
}
