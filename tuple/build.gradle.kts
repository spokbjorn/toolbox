plugins {
    `java-library`
    `maven-publish`
    signing
}

group = "org.spokbjorn"
version = "0.0.1-SNAPSHOT"

dependencies {
    compileOnly(libs.jetbrains.annotations)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

publishing {
    publications {
        create<MavenPublication>("tuple") {
            groupId = "org.spokbjorn"
            artifactId = "tuple"
            version = "0.0.1-SNAPSHOT"

            from(components["java"])
            pom {
                name.set("Tuple")
                description.set("A collection of tuples")
                url.set("http://github.com/spokbjorn/toolbox")
                licenses {
                    license {
                        name.set("MIT License")
                    }
                }
                scm {
                    connection.set("scm:git://github.com/spokbjorn/toolbox.git")
                    developerConnection.set("scm:git://github.com/spokbjorn/toolbox.git")
                    url.set("http://github.com/spokbjorn/toolbox")
                }
            }
            repositories {
                maven {
                    credentials {
                        username = project.properties["ossrhUsername"].toString()
                        password = project.properties["ossrhPassword"].toString()
                    }

                    url = if (version.toString().endsWith("-SNAPSHOT")) {
                        uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
                    } else {
                        uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                    }
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["tuple"])
}
