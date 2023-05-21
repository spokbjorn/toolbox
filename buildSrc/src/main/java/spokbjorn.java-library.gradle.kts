import java.util.Base64

plugins {
    `java-library`
    signing
    id("maven-publish")
}

project.configure<JavaPluginExtension> {
    withJavadocJar()
    withSourcesJar()
}

project.configure<PublishingExtension> {
    publications {
        create<MavenPublication>(project.name) {
            groupId = property("POM_GROUP_ID").toString()
            artifactId = property("POM_ARTIFACT_ID").toString()
            version = property("POM_VERSION").toString()

            from(components["java"])

            pom {
                name.set(property("POM_NAME").toString())
                description.set(property("POM_DESCRIPTION").toString())
                url.set(property("POM_URL").toString())
                licenses {
                    license {
                        if (hasProperty("POM_LICENSE_NAME"))
                            name.set(property("POM_LICENSE_NAME").toString())
                        if (hasProperty("POM_LICENSE_URL"))
                            url.set(property("POM_LICENSE_URL").toString())
                        if (hasProperty("POM_LICENSE_DISTRIBUTION"))
                            distribution.set(property("POM_LICENSE_DISTRIBUTION").toString())
                    }
                }
                developers {
                    developer {
                        if (hasProperty("POM_ORGANIZATION"))
                            organization.set(property("POM_ORGANIZATION").toString())
                        if (hasProperty("POM_ORGANIZATION_URL"))
                            organizationUrl.set(property("POM_ORGANIZATION_URL").toString())
                    }
                }
                scm {
                    if (hasProperty("POM_SCM_CONNECTION"))
                        connection.set(property("POM_SCM_CONNECTION").toString())
                    if (hasProperty("POM_SCM_DEVELOPER_CONNECTION"))
                        developerConnection.set(property("POM_SCM_DEVELOPER_CONNECTION").toString())
                    if (hasProperty("POM_SCM_URL"))
                        url.set(property("POM_SCM_URL").toString())
                }
            }

            repositories {
                maven {
                    if (hasProperty("ossrhUsername") && hasProperty("ossrhPassword")) {
                        credentials {
                            username = findProperty("ossrhUsername").toString()
                            password = findProperty("ossrhPassword").toString()
                        }
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

project.configure<SigningExtension> {
    if (hasProperty("signingKey") && hasProperty("signingPassword")) {
        val decoder = Base64.getDecoder()
        useInMemoryPgpKeys(
            /* defaultSecretKey = */ String(decoder.decode(findProperty("signingKey").toString())),
            /* defaultPassword = */ findProperty("signingPassword").toString()
        )
        sign(publishing.publications[project.name])
    }
}
