plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.app.oneplace"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.oneplace"
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //Firebase
    //Firebase - Used for authentication, crashlytics, analytics, firestore and messaging.
    implementation("com.google.firebase:firebase-auth:22.2.0")

    //Core
    implementation("androidx.core:core-ktx:1.12.0")

    // Compose library jetpack compose
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Material library
    implementation("androidx.compose.material3:material3")
    implementation ("androidx.compose.material:material:1.5.4")

    // LifeCycle Components
    val lifeCycleVersion="2.6.2"
    // ViewModel Lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion")
    // ViewModel Lifecycle for Compose
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifeCycleVersion")
    // Live data
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.0")
    // Lifecycles only (without viewModel or LiveData)
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion")



    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Preview
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Navigation Component
    implementation("androidx.navigation:navigation-compose:2.7.5")

    // WorkManager
    // This is an optional dependency that helps with more reliable and performant background processing on older API versions
    implementation ("androidx.work:work-runtime-ktx:2.8.1")
    implementation ("androidx.work:work-gcm:2.8.1")

    // Retrofit
    // It is used to make netwwork API calls
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // Retrofit with Moshi Converter
    // Used to make network API calls and Convert the json to kotlin objects and vice versa
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    // Do I need okHTTP with Retrofi?
    // In summary, OkHttp is a lower-level HTTP client that focuses on handling network connections and providing core HTTP functionalities,
    //  while Retrofit builds on top of OkHttp to offer a more user-friendly and high-level API for making RESTful API calls with type-safe responses.
    // OkHttp
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")

    // Moshi
    // Moshi is a JSON library for Android jav and kotlin,used to parse the java and kotlin classes
    implementation ("com.squareup.moshi:moshi-kotlin:1.15.0")

    // Hilt
    // Hilt is an opinionated dependency injection library for Android that reduces the boilerplate
    // of using manual DI in your project
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-compiler:2.47")
    annotationProcessor( "com.google.dagger:hilt-compiler:2.47")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")

    // Room
    //Room is a persistence library for Android that is part of Google's Android Jetpack project.
    // Room acts as an abstraction layer over SQLite, allowing for fluent database access while leveraging SQLite's full power
    val room_version = "2.6.0"

    implementation ("androidx.room:room-runtime:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")
    annotationProcessor ("androidx.room:room-compiler:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")

    // JWT
    //Our mobile SDKs use JSON Web Tokens (JWT) to authenticate your app.
    //These are a commonly used method for providing authentication and authorisation using one simple token.
    implementation ("io.github.nefilim.kjwt:kjwt-core:0.8.0")
    implementation ("io.github.nefilim.kjwt:kjwt-jwks:0.8.0")
    implementation ("io.arrow-kt:arrow-core:1.0.1")

    // Lottie
    // Lottie is a library for Android, iOS, Web, and Windows that parses
    // Adobe After Effects animations exported as JSON with Bodymovin and renders them natively on mobile and on the web
    implementation ("com.airbnb.android:lottie-compose:6.1.0")

    //Coil
    // Image loading library backed by kotlin coroutines
    implementation ("io.coil-kt:coil-compose:2.4.0")

}

kapt{
    correctErrorTypes=true
}