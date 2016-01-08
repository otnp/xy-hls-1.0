#hlsplayer
#IDE:  android studio 1.5.1
#Gradle 2.8

``` android {
    compileSdkVersion 23
    buildToolsVersion "23.0.2"

    defaultConfig {
        applicationId "com.scmxkt.app.xy_hls_10"
        minSdkVersion 14
        targetSdkVersion 23
        versionCode 1
        versionName "1.0"
    }
}

repositories {
    jcenter { url "http://jcenter.bintray.com/" }
    mavenCentral()
}


dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.github.bumptech.glide:glide:3.6.1'
    compile 'com.google.android.exoplayer:exoplayer:r1.5.3'
    compile 'com.android.support:appcompat-v7:23.1.1'
    compile 'com.squareup.okhttp3:okhttp:3.0.0-RC1'
    compile 'com.google.code.gson:gson:2.5'
}


#注意：
本示例程序只加载静态文件列表，读取远程服务器视频资源。
通过videoview 实现视频播放。
图片资源通过Glide实现加载。


##视频播放未实现全屏功能：
activty未实现返回功能；
未实现通过远程读取xml或json来实现列表填充；
资源加载未优化，网速异常可能会导致app崩溃。


