import kotlin.reflect.full.memberProperties

private const val FEATURE_PREFIX = ":module_"

object ModuleDependency {
    const val APP = ":app"
    const val LIBRARY_BASE = ":base_library"
    const val MODULE_LOGIN = "${FEATURE_PREFIX}login"
    const val MODULE_HOME = "${FEATURE_PREFIX}home"
    const val MODULE_MINE = "${FEATURE_PREFIX}mine"



    fun getAllModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .map { it.getter.call().toString() }
        .toSet()

    fun getDynamicFeatureModules() = getAllModules()
        .filter { it.startsWith(FEATURE_PREFIX) }
        .toSet()
}
