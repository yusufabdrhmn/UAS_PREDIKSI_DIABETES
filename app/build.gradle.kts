plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.machinelearning_model_deployment"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.machinelearning_model_deployment"
        minSdk = 26
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    // Tambahkan bagian ini untuk TensorFlow Lite agar model bisa diakses
    aaptOptions {
        noCompress("tflite") // Mencegah kompresi file .tflite
    }

    // BARU: Aktifkan Data Binding di sini
    buildFeatures {
        viewBinding = true // Untuk View Binding (juga bisa untuk Data Binding)
        // dataBinding = true // Ini juga bisa digunakan jika Anda ingin fitur Data Binding penuh
        // View Binding adalah subset dari Data Binding yang lebih sederhana
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Dependency TensorFlow Lite (sudah ditambahkan sebelumnya)
    implementation("org.tensorflow:tensorflow-lite:2.15.0")
}