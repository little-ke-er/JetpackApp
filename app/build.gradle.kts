import ModuleDependency.getDynamicFeatureModules
import com.haikun.dfm.addProductFlavors
import com.haikun.dfm.setSrcDirs

plugins {

    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.KOTLIN_ANDROID)
    //navigation.safeargs
    id(GradlePluginId.SAFE_ARGS)
    id(GradlePluginId.KAPT)
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK_VERSION
    buildToolsVersion = AndroidConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = AndroidConfig.ID
        multiDexEnabled = true
        minSdk = AndroidConfig.MIN_SDK_VERSION
        targetSdk = AndroidConfig.TARGET_SDK_VERSION
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
        //添加每个dynamicFeatures module名字的数组，可以通过BuildConfig获取
        buildConfigField("String[]", "MODULE_NAMES", getModuleNamesStr())
    }

    signingConfigs {

        register(BuildType.RELEASE) {
            keyAlias = BuildTypeRelease.keyAlias
            keyPassword = BuildTypeRelease.keyPassword
            storeFile = file(BuildTypeRelease.storeFile)
            storePassword = BuildTypeRelease.storePassword
        }

        getByName(BuildType.DEBUG) {
            keyAlias = BuildTypeDebug.keyAlias
            keyPassword = BuildTypeDebug.keyPassword
            storeFile = file(BuildTypeDebug.storeFile)
            storePassword = BuildTypeDebug.storePassword
        }
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled

        }
    }

    //差异化版本管理,可以配置不同环境下的URL地址或者其他变量
    addProductFlavors()

    //配置kotlin源代码文件夹
    setSrcDirs()

    //开启dataBinding
    buildFeatures {
        dataBinding = true
        compose = true
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = CoreVersion.COMPOSE
        kotlinCompilerVersion = CoreVersion.KOTLIN
    }

    dynamicFeatures.addAll(getDynamicFeatureModules().toMutableSet())

}

dependencies {
    api(project(ModuleDependency.LIBRARY_BASE))
    kapt(LibraryDependency.ROOM_COMPILER)

    //添加测试
    addTestImplementation()
}



fun getModuleNamesStr(): String {
    val value = ModuleDependency.getDynamicFeatureModules()
        .map { it.replace(":module_", "") }
        .toSet()

    return value.joinToString(
        prefix = "{",
        separator = ",",
        postfix = "}",
        transform = { "\"$it\"" })

}


