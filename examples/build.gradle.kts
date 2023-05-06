plugins {
    id("java")
}

group = "org.spokbjorn"

dependencies {
    implementation(project(":tuple"))
    implementation(project(":lazy"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
