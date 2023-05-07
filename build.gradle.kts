import kotlin.io.path.Path

group = "org.spokbjorn"

subprojects {
    tasks.withType<JavaCompile> {
        apply(plugin = "checkstyle")
    }

    tasks.withType<Checkstyle> {
        configFile = Path("$rootDir", "config", "checkstyle.xml").toAbsolutePath().toFile()
        version = "10.10.0"
        ignoreFailures = false
        maxWarnings = 0
    }

}
