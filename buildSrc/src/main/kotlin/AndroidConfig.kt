object AndroidConfig {
    const val COMPILE_SDK_VERSION = 30
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 30
    const val BUILD_TOOLS_VERSION = "30.0.2"

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val ID = "com.haikun.jetpackapp"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    const val keyAlias = "release"
    const val keyPassword = "123456"
    const val storeFile = "keys/release.jks"
    const val storePassword = "123456"
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
    const val keyAlias = "release"
    const val keyPassword = "123456"
    const val storeFile = "keys/release.jks"
    const val storePassword = "123456"
}