plugins {
    java
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.bmuschko.docker-spring-boot-application") version "9.4.0"
    kotlin("jvm")
}

group = "de.petunia"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter:2.17.0")
    implementation("io.micrometer:micrometer-tracing-bridge-otel")
    implementation("io.opentelemetry:opentelemetry-exporter-otlp")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

docker {
    springBootApplication {
        baseImage.set("eclipse-temurin:21-jre-alpine")
        maintainer.set("Felix Roske")
        ports.set(listOf(8080))
        images.set(listOf("roskenet/${project.name}:${project.version}"))
        jvmArgs.set(listOf("-Xmx512m"))
    }
}
