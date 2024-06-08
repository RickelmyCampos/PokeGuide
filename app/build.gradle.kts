import java.io.FileInputStream
import java.util.Properties

plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization") version "1.9.23"
}

android {
    namespace = "com.gilbersoncampos.pokeguide"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.gilbersoncampos.pokeguide"
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            val secretPropertiesFile = rootProject.file("secrets.properties")
            val secretProperties = Properties()
            secretProperties.load(FileInputStream(secretPropertiesFile))
            buildConfigField(
                "String",
                "BASE_URL",
                secretProperties["BASE_URL"] as String
            )
        }
        debug {
            val secretPropertiesFile = rootProject.file("secrets.properties")
            val secretProperties = Properties()
            secretProperties.load(FileInputStream(secretPropertiesFile))
            buildConfigField(
                "String",
                "BASE_URL",
                secretProperties["BASE_URL"] as String
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
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    hilt {
        enableTransformForLocalTests = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    kapt {
        correctErrorTypes = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val navigationCompose = "2.7.7"
    implementation("androidx.navigation:navigation-compose:$navigationCompose")

    val hiltVersion = "2.50"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:$hiltVersion")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:$hiltVersion")
    //serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    //retrofit
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    // coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2024.02.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}