plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

description = "AppEvents"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
