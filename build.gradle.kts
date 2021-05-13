buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        //GradlePlugins是定义在buildSrc下的单例类
        classpath(GradlePlugins.ANDROID_GRADLE)
        classpath(GradlePlugins.KOTLIN_GRADLE_PLUGIN)
        classpath(GradlePlugins.SAFE_ARGS)//navigation导航安全传参
        classpath(GradlePlugins.KOIN_GRADLE_PLUGIN) //koin依赖注入
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}