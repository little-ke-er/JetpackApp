private object LibraryVersion {
    const val RETROFIT = "2.9.0"
    const val OK_HTTP = "4.9.0"
    const val APP_COMPAT = "1.2.0"
    const val MATERIAL = "1.1.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val VECTOR_DRAWABLE = "1.1.0"
    const val CORE_KTX = "1.3.2"
    const val PAGING = "3.0.0-alpha10"
    const val COIL = "1.1.1"
    const val ROOM = "2.3.0-alpha03"
    const val DATA_STORE = "1.0.0-alpha05"
    const val PROTOBUF = "3.11.0"
    const val LIVE_BUS = "1.7.3"
    const val LIVEDATA_KTX = "2.2.0"
}

object LibraryDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${CoreVersion.KOTLIN}"
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${CoreVersion.KOTLIN}"

    const val CORE_KTX = "androidx.core:core-ktx:${LibraryVersion.CORE_KTX}"

    const val APP_COMPAT = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPAT}"

    const val MATERIAL = "com.google.android.material:material:${LibraryVersion.MATERIAL}"

    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"

    const val VECTOR_DRAWABLE =
        "androidx.vectordrawable:vectordrawable:${LibraryVersion.VECTOR_DRAWABLE}"

    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${CoreVersion.NAVIGATION}"
    const val NAVIGATION_DYNAMIC_FEATURE_FRAGMENT_KTX = "androidx.navigation:navigation-dynamic-features-fragment:${CoreVersion.NAVIGATION}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${CoreVersion.NAVIGATION}"

    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersion.COROUTINES_ANDROID}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibraryVersion.RETROFIT}"
    const val RETROFIT_MOSHI_CONVERTER =
        "com.squareup.retrofit2:converter-moshi:${LibraryVersion.RETROFIT}"
    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${LibraryVersion.OK_HTTP}"
    const val LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.OK_HTTP}"

    const val COIL = "io.coil-kt:coil:${LibraryVersion.COIL}"
    const val COIL_GIF = "io.coil-kt:coil-gif:${LibraryVersion.COIL}"

    const val PAGING = "androidx.paging:paging-runtime:${LibraryVersion.PAGING}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${LibraryVersion.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${LibraryVersion.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${LibraryVersion.ROOM}"

    const val KOIN_SCOPE = "org.koin:koin-androidx-scope:${CoreVersion.KOIN}"
    const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${CoreVersion.KOIN}"
    const val KOIN_FRAGMENT = "org.koin:koin-androidx-fragment:${CoreVersion.KOIN}"

    const val DATA_STORE = "androidx.datastore:datastore-preferences:${LibraryVersion.DATA_STORE}"
    const val DATA_STORE_CORE = "androidx.datastore::datastore-core:${LibraryVersion.DATA_STORE}"
    const val PROTOBUF = "com.google.protobuf:protobuf-java:${LibraryVersion.PROTOBUF}"

    const val LIVE_BUS = "com.jeremyliao:live-event-bus-x:${LibraryVersion.LIVE_BUS}"

    const val LIVE_DATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersion.LIVEDATA_KTX}"

    const val COMPOSE_UI = "androidx.compose.ui:ui:${CoreVersion.COMPOSE}"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${CoreVersion.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${CoreVersion.COMPOSE}"
    const val COMPOSE_ACTIVITY =
        "androidx.activity:activity-compose:${CoreVersion.COMPOSE_ACTIVITY}"
}
