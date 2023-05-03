plugins {
    `java-library`
}

group = "org.spokbjorn"
version = "1.0.0"

dependencies {
    compileOnly(libs.jetbrains.annotations)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
