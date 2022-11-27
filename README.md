# ReelAds Samples

Samples of integrating the banner display library into an Android application.

## Quick start:

1. Register on [ReelAds](https://reelads.net/sign-up)
2. Download the archive with the banner display library [reelads-android-libs](https://reelads.net/quick-start/download-libs)
3. Unpack the archive into the `libs` directory
4. Add instructions to the build file
```
android {
    sourceSets {
        main {
            jniLibs.srcDirs = ['libs']
        }
    }

    packagingOptions {
        resources {
            exclude "META-INF/*"
        }
    }
}

dependencies {
    implementation 'io.netty:netty-all:4.1.85.Final'
    implementation fileTree(include: ['*.aar'], dir: 'libs')
}
```
5. Add user permissions for internet access to AndroidManifest.xml
```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
```

## Screenshots

|                 BannerSampleActivity                  |                  MediatorSampleActivity                   |
|:-----------------------------------------------------:|:---------------------------------------------------------:|
| ![BannerSampleActivity](screenshot-banner-sample.png) | ![MediatorSampleActivity](screenshot-mediator-sample.png) |
