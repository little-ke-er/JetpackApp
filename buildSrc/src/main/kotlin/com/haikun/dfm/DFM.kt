package com.haikun.dfm

import AndroidConfig
import com.android.build.gradle.TestedExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import addTestImplementation
import org.gradle.api.Action
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import addProductFlavors
import setSrcDirs

class DFM :Plugin<Project>{

    override fun apply(target: Project) {
        target.configurePlugins()
        target.configureAndroid()
        target.configureDependencies()
    }
}


internal fun Project.configureAndroid() = this.extensions.getByType(TestedExtension::class.java).run {
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
    setSrcDirs()

    dataBinding.isEnabled = true

    //差异化版本管理,可以配置不同环境下的URL地址或者其他变量
    addProductFlavors()
}


internal fun Project.configureDependencies() = dependencies {
    add("implementation", project(ModuleDependency.APP))
    addTestImplementation()
}

internal fun Project.configurePlugins() {
    plugins.apply(GradlePluginId.ANDROID_DYNAMIC_FEATURE)
    plugins.apply(GradlePluginId.KOTLIN_ANDROID)
    plugins.apply(GradlePluginId.SAFE_ARGS)
    plugins.apply(GradlePluginId.KAPT)
}

fun TestedExtension.kotlinOptions(configure: Action<KotlinJvmOptions>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("kotlinOptions", configure)
