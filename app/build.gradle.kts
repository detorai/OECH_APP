import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "1.7.10"
}

android {
    namespace = "com.example.oech_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.oech_app"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true


             }
        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "SUPABASE_ANON_KEY", "\"${properties.getProperty("SUPABASE_ANON_KEY")}\"")
        buildConfigField("String", "SUPABASE_URL", "\"${properties.getProperty("SUPABASE_URL")}\"")

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
    implementation(libs.firebase.crashlytics.buildtools)
    implementation(libs.core)
    implementation(libs.yandex.mapkit.kmp)
    implementation(libs.yandex.mapkit.kmp.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.jbcrypt)
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.screenmodel)
    implementation(libs.voyager.bottom.sheet.navigator)
    implementation(libs.voyager.tab.navigator)
    implementation(libs.voyager.transitions)
    implementation(libs.voyager.koin)
    implementation(libs.voyager.hilt)
    implementation(libs.voyager.livedata)
    implementation(libs.voyager.kodein)
    implementation(libs.voyager.rxjava)
    implementation (libs.androidx.activity.compose)
    implementation (libs.androidx.lifecycle.viewmodel.compose)
    implementation (libs.ui)
    implementation (libs.androidx.material)
    implementation (libs.ui.tooling)
    implementation (libs.material)
    implementation (libs.accompanist.pager)
    implementation (libs.accompanist.pager.indicators)


    implementation (libs.hilt.android)
    annotationProcessor (libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation (libs.postgrest.kt)
    implementation (libs.storage.kt)
    implementation (libs.auth.kt)
    implementation (libs.ktor.client.android)
    implementation (libs.ktor.client.core)
    implementation (libs.ktor.utils)
}