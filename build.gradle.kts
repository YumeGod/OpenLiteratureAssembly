import org.jetbrains.kotlin.gradle.targets.js.npm.includedRange
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    id("java")
    id("java-library")
    id("application")
}

group = "just.monika.主播你妈死了"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://gitee.com/ioypo/skid-central-mirror/raw/repository/")
}

dependencies {
    testImplementation(kotlin("test"))

}
apply("anotherbuild.gradle")
tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
application{
    mainClassName="Start"

}
