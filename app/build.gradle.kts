plugins {
    id("com.android.application")
    alias(libs.plugins.jetbrains.kotlin.android)

}

android {
    namespace = "com.example.speedo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.speedo"
        minSdk = 21
        targetSdk = 33
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.volley)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.androidx.core.ktx)
    implementation (libs.androidx.appcompat)
    implementation (libs.material)

    // Jetpack Compose
    implementation (libs.ui)
    implementation ("androidx.compose.material:material:1.6.8")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.6.8")
    implementation (libs.androidx.lifecycle.runtime.ktx)
    implementation ("androidx.activity:activity-compose:1.9.1")

    // ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
    implementation ("com.google.android.material:material:1.12.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    implementation (libs.androidx.appcompat)

    implementation("androidx.navigation:navigation-compose:2.8.0")



}
