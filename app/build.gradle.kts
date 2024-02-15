plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.pablojmuratore.demousers"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pablojmuratore.demousers"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.test.ext.junit)

    // compose
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose.implementation)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.bundles.compose.debug.implementation)

    // hilt
    implementation(libs.bundles.hilt.implementation)
    kapt(libs.hilt.compiler)

    // navigation component
    implementation(libs.bundles.navigation.implementation)
    androidTestImplementation(libs.navigation.testing)

    implementation(project(":theme"))
    implementation(project(":features:users"))
}

kapt {
    correctErrorTypes = true
}
