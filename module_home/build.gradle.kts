plugins {
    id(GradlePluginId.DFM)
}

/*
plugins {
    id(GradlePluginId.ANDROID_DYNAMIC_FEATURE)
    id(GradlePluginId.KOTLIN_ANDROID)
    //navigation.safeargs
    id(GradlePluginId.SAFE_ARGS)
    id(GradlePluginId.KAPT)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    //代码文件夹设置
    sourceSets.getByName("main") {
        java.srcDirs("src/main/kotlin")
    }
    sourceSets.getByName("test") {
        java.srcDirs("src/test/kotlin")
    }
    sourceSets.getByName("androidTest") {
        java.srcDirs("src/androidTest/kotlin")
    }
    dataBinding.isEnabled = true

    //差异化版本管理,可以配置不同环境下的URL地址或者其他变量
    //addProductFlavors()
    flavorDimensions(ENVIRONMENT_DIMENSIONS)
    productFlavors{
        create(DevEnvironmentDimensions.name){
            buildConfigField("String", "BASE_URL", DevEnvironmentDimensions.baseUrl)
            setDimension(DevEnvironmentDimensions.dimensions)
        }
        create(MasterEnvironmentDimensions.name){
            buildConfigField("String", "BASE_URL", MasterEnvironmentDimensions.baseUrl)
            setDimension(MasterEnvironmentDimensions.dimensions)
        }
    }

}

dependencies {
    //直接依赖app即可
    implementation(project(ModuleDependency.APP))
    kapt(LibraryDependency.ROOM_COMPILER)

    addTestImplementation()
}


*/
