plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "com.kh.flicks.movie.streaming"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.kh.flicks.movie.streaming"
		minSdk = 22
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

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
	dataBinding {
		enable = true
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {

	implementation("androidx.core:core-ktx:1.12.0")
	implementation("androidx.appcompat:appcompat:1.6.1")
	implementation("com.google.android.material:material:1.10.0")
	implementation("androidx.constraintlayout:constraintlayout:2.1.4")


	// coroutine
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

	// dots indicator library.
	implementation("com.tbuonomo:dotsindicator:5.0")
	// smooth bottom navigation bar library.
	implementation("com.github.ibrahimsn98:SmoothBottomBar:1.7")
	// Lottie : library for animation.
	implementation("com.airbnb.android:lottie:3.4.0")
	// glide : for loading image ulr
	implementation("com.github.bumptech.glide:glide:4.16.0")
	// media3 exoplayer3 : for video playing
	implementation("com.google.android.exoplayer:exoplayer:2.19.1")

	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
}