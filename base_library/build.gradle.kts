plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KAPT)
    id(GradlePluginId.KOIN)
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

    buildTypes {

        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures.dataBinding = true

    //配置kotlin源代码文件夹
    setSrcDirs()
}

dependencies {
    api(LibraryDependency.KOTLIN)
    api(LibraryDependency.KOTLIN_REFLECT)

    api(LibraryDependency.CORE_KTX)
    api(LibraryDependency.APP_COMPAT)
    api(LibraryDependency.MATERIAL)
    api(LibraryDependency.CONSTRAINT_LAYOUT)
    api(LibraryDependency.VECTOR_DRAWABLE)

    api(LibraryDependency.NAVIGATION_FRAGMENT_KTX)
    api(LibraryDependency.NAVIGATION_DYNAMIC_FEATURE_FRAGMENT_KTX)
    api(LibraryDependency.NAVIGATION_UI_KTX)

    api(LibraryDependency.COROUTINES_ANDROID)//协程

    api(LibraryDependency.RETROFIT)
    api(LibraryDependency.RETROFIT_MOSHI_CONVERTER)//json转换
    api(LibraryDependency.OK_HTTP)
    api(LibraryDependency.LOGGING_INTERCEPTOR)

    api(LibraryDependency.COIL)
    api(LibraryDependency.COIL_GIF)

    api(LibraryDependency.PAGING)

    api(LibraryDependency.ROOM_RUNTIME)
    api(LibraryDependency.ROOM_KTX)
    kapt(LibraryDependency.ROOM_COMPILER)

    api(LibraryDependency.KOIN_SCOPE)
    api(LibraryDependency.KOIN_VIEWMODEL)
    api(LibraryDependency.KOIN_FRAGMENT)

    api(LibraryDependency.DATA_STORE)
    //api(LibraryDependency.DATA_STORE_CORE)
    api(LibraryDependency.PROTOBUF)

    api(LibraryDependency.LIVE_BUS)

    api(LibraryDependency.LIVE_DATA_KTX)

    api(LibraryDependency.COMPOSE_UI)
    api(LibraryDependency.COMPOSE_UI_TOOLING)
    api(LibraryDependency.COMPOSE_MATERIAL)
    api(LibraryDependency.COMPOSE_ACTIVITY)
    addTestImplementation()
}