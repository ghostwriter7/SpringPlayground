pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "SpringPlayground"

include("Beans")
include("AspectOrientedProgramming")
include("AppEvents")
include("JDBC")
include("ORM")
include("Messaging")
include("Web")