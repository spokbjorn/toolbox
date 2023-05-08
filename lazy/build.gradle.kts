plugins {
    `java-library`
    id("spokbjorn.publish")
}

group = "org.spokbjorn"
version = "0.0.1-SNAPSHOT"

dependencies {
    api(libs.jetbrains.annotations)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

tasks.test {
    useJUnitPlatform()
}
