plugins {
    java
    `maven-publish`
}

group = "me.alikuxac.vortexia"

val refName = System.getenv("GITHUB_REF_NAME") ?: "local"
val refType = System.getenv("GITHUB_REF_TYPE") ?: "branch"

val projectVersion: String by project
val buildNumber = System.getenv("GITHUB_RUN_NUMBER") ?: "0"
val commitHash = System.getenv("GITHUB_SHA")?.take(7) ?: "local"

version = if (refType == "tag") {
    refName.replaceFirst("v", "")
} else if (refName == "master" || refName == "main") {
    projectVersion
} else if (refName == "development") {
    "$projectVersion-b$buildNumber"
} else {
    "$projectVersion-$commitHash"
}


repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

val paperApiVersion: String by project
val nettyVersion: String by project
val junitVersion: String by project

dependencies {
    compileOnly("io.papermc.paper:paper-api:$paperApiVersion")
    compileOnly("io.netty:netty-buffer:$nettyVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("io.netty:netty-buffer:$nettyVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(21)
        options.compilerArgs.add("-Xlint:all")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Vortexia/vortexia-api")
            credentials {
                username = "alikuxac"
                password = System.getenv("PUBLISH_TOKEN")
            }
        }
    }
}
