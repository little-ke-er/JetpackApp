import org.gradle.kotlin.dsl.DependencyHandlerScope

private object TestLibraryVersion {
    const val JUNIT = "4.12"
    const val EXT_JUNIT = "1.1.1"
    const val ESPRESSO_CORE = "3.2.0"
    const val LEAK_CANARY = "2.6"
}

object TestLibraryDependency {
    const val JUNIT = "junit:junit:${TestLibraryVersion.JUNIT}"
    const val EXT_JUNIT = "androidx.test.ext:junit:${TestLibraryVersion.EXT_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${TestLibraryVersion.ESPRESSO_CORE}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${CoreVersion.COROUTINES_ANDROID}"
    const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:${TestLibraryVersion.LEAK_CANARY}"
}

fun DependencyHandlerScope.addTestImplementation() {
    add("testImplementation", TestLibraryDependency.JUNIT)
    add("androidTestImplementation", TestLibraryDependency.EXT_JUNIT)
    add("androidTestImplementation", TestLibraryDependency.ESPRESSO_CORE)
    add("debugImplementation", TestLibraryDependency.LEAK_CANARY)
}
