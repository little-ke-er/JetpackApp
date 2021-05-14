
import com.android.build.gradle.TestedExtension
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer

fun TestedExtension.setSrcDirs(){
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

fun TestedExtension.addProductFlavors() {
    flavorDimensions(Environment.ENVIRONMENT_DIMENSIONS)
    productFlavors {
        create(this, DevEnvironmentDimensions)
        create(this, MasterEnvironmentDimensions)
    }
}

fun create(
    namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>,
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

