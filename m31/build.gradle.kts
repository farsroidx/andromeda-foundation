plugins {
    // android
    id("com.android.library")
    // jetbrains
    id("org.jetbrains.kotlin.android")
    // maven
    id("maven-publish")
}

android {

    namespace  = "ir.farsroidx.m31"
    compileSdk = 35

    defaultConfig {
        multiDexEnabled           = true
        minSdk                    = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {

        release {

            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "r8-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    // Android-X
    implementation("androidx.core:core-ktx:1.15.0")

    // Koin
    implementation("io.insert-koin:koin-core:4.0.3")

    // Google
    implementation("com.google.code.gson:gson:2.11.0")

    // Jetbrains
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

}

publishing {

    publications {

        register<MavenPublication>("release") {

            groupId    = "ir.farsroidx.m31"
            artifactId = "andromeda-foundation"
            version    = "2.0.0"

            afterEvaluate {

                from(
                    components["release"]
                )
            }
        }
    }
}