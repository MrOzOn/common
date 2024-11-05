plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.mrozon.myapplication34568345"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mrozon.common_example"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += "room.schemaLocation" to  "$projectDir/schemas"
            }
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(project(":common"))
    implementation(libs.logging.timber)
    coreLibraryDesugaring(libs.desugar.jdk.libs)
    // common android+compose dependencies
    implementation(libs.bundles.common)
    implementation(libs.kotlin.datetime)
    implementation(platform(libs.androidx.compose.bom))
    // using material3
    implementation(libs.androidx.material3)
    implementation(libs.material.icons.extended)
    // using HILT
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    // hilt and navigation in compose
    implementation(libs.hilt.navigation.compose)
    // Room
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}