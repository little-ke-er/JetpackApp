plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

object GradlePluginVersion {
    const val ANDROID_GRADLE = "7.0.0-alpha14"
    const val KOTLIN = "1.4.32"
}

object GradlePlugins {
    const val ANDROID_GRADLE = "com.android.tools.build:gradle:${GradlePluginVersion.ANDROID_GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradlePluginVersion.KOTLIN}"
}


dependencies {
    implementation(GradlePlugins.ANDROID_GRADLE)
    implementation(GradlePlugins.KOTLIN_GRADLE_PLUGIN)
    implementation(gradleApi())
    implementation(localGroovy())
}
