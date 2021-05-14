plugins{
    id(GradlePluginId.DFM)
}

android{
    kotlinOptions{
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}