plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    compileSdk = 34
    namespace = "com.mrozon.common"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

kotlin {
    sourceSets {
        java {
            dependencies {
                implementation(libs.androidx.lifecycle.runtime.ktx)
                implementation(libs.logging.timber)
                implementation(libs.androidx.material3)
                implementation(platform(libs.androidx.compose.bom))
                implementation(libs.androidx.ui.tooling.preview)

                implementation(libs.material)
                testImplementation(libs.junit)
            }
        }
    }
}

