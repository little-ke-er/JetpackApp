object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
    const val KAPT = "kotlin-kapt"
    const val KOIN = "koin"
    const val DFM = "com.haikun.dfm"
}


object GradlePlugins {

    const val ANDROID_GRADLE = "com.android.tools.build:gradle:${CoreVersion.ANDROID_GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${CoreVersion.KOTLIN}"
    const val SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${CoreVersion.NAVIGATION}"
    const val KOIN_GRADLE_PLUGIN = "org.koin:koin-gradle-plugin:${CoreVersion.KOIN}"
}
