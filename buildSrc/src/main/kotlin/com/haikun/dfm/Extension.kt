package com.haikun.dfm
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.NamedDomainObjectContainer

fun CommonExtension<*,*,*,*>.setSrcDirs(){
    sourceSets.getByName("main") {
        java.srcDirs("src/main/kotlin")
    }
    sourceSets.getByName("test") {
        java.srcDirs("src/test/kotlin")
    }
    sourceSets.getByName("androidTest") {
        java.srcDirs("src/androidTest/kotlin")
    }
}


object Environment{
    const val ENVIRONMENT_DIMENSIONS = "environment"
}

fun CommonExtension<*,*,*,*>.addProductFlavors() {
    flavorDimensions(Environment.ENVIRONMENT_DIMENSIONS)
    productFlavors {
        create(this, DevEnvironmentDimensions)
        create(this, MasterEnvironmentDimensions)
    }
}


fun create(
    namedDomainObjectContainer: NamedDomainObjectContainer<out com.android.build.api.dsl.ProductFlavor>,
    dimensions: EnvironmentDimensions
) {
    namedDomainObjectContainer.create(dimensions.name) {
        buildConfigField("String", "BASE_URL", dimensions.baseUrl)
        dimension = dimensions.dimensions
    }
}

interface EnvironmentDimensions {
    val dimensions: String
    val name: String
    val baseUrl: String
}

object DevEnvironmentDimensions : EnvironmentDimensions {
    override val dimensions: String = Environment.ENVIRONMENT_DIMENSIONS
    override val name: String = "dev"
    override val baseUrl: String = "\"http://haikun.vaiwan.com/test/\""
}

object MasterEnvironmentDimensions : EnvironmentDimensions {
    override val dimensions: String = Environment.ENVIRONMENT_DIMENSIONS
    override val name: String = "master"
    override val baseUrl: String = "\"http://haikun.vaiwan.com/test/\""
}

