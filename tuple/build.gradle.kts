plugins {
    id("spokbjorn.java-library")
}

group = "org.spokbjorn"
version = "0.0.1-SNAPSHOT"

dependencies {
    api(libs.jetbrains.annotations)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
