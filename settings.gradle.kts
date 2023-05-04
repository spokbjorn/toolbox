rootProject.name = "toolbox"
include("base")

dependencyResolutionManagement {
    repositories {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        mavenCentral()
    }
}

include("tuple")
include("examples")
