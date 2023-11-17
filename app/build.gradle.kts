plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ba.simovic.androidexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "ba.simovic.androidexample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of("17"))
        }
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(project(mapOf("path" to ":design")))
    val composeVersion = "1.5.4"
    val roomVersion = "2.6.0"
    val espressoVersion = "3.5.1"
    val testCoreVerison = "1.5.0"
    val uiAutomatorVersion = "2.2.0"
    val coroutineVersion = "1.6.0-native-mt"
    val timberVersion = "5.0.1"
    val daggerHiltVersion = "2.46"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("com.jakewharton.timber:timber:$timberVersion")

    // DI

    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")

    // Local database

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    // Compose

    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.4")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.23.0")

    // Tests
    androidTestImplementation("androidx.test:core:$testCoreVerison")
    androidTestImplementation("androidx.test:core-ktx:$testCoreVerison")
    androidTestImplementation("androidx.test:runner:$testCoreVerison")
    androidTestImplementation("androidx.test:rules:$testCoreVerison")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation("androidx.test.uiautomator:uiautomator:$uiAutomatorVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:$espressoVersion")
    androidTestImplementation("androidx.test.espresso:espresso-intents:$espressoVersion")
    implementation("androidx.test.espresso.idling:idling-concurrent:$espressoVersion")
    implementation("androidx.test.espresso:espresso-idling-resource:$espressoVersion")
    testImplementation("com.google.firebase:testlab-instr-lib:0.2")
    androidTestImplementation("androidx.test:orchestrator:1.4.2")
    androidTestImplementation("androidx.annotation:annotation:1.7.0")
    testImplementation("com.google.dagger:hilt-android-testing:$daggerHiltVersion")
}