#hlsplayer
##IDE:  android studio 1.5.1
##Gradle 2.8
----

    android {
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

-----

#注意：
本示例程序只加载静态文件列表，读取远程服务器视频资源。
通过videoview 实现视频播放。
图片资源通过Glide实现加载。


##视频播放未实现全屏功能：
activty未实现返回功能；
未实现通过远程读取xml或json来实现列表填充；
资源加载未优化，网速异常可能会导致app崩溃。

##参考网站：
配色
http://www.materialpalette.com/deep-purple/teal

videoview全屏
https://github.com/rtoshiro/FullscreenVideoView

Retrofit 2.0：有史以来最大的改进
http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0915/3460.html

android-examples
https://github.com/nex3z/android-examples

Retrofit使用方法举例
http://blog.nex3z.com/2015/12/28/retrofit%E4%BD%BF%E7%94%A8%E6%96%B9%E6%B3%95%E7%AE%80%E4%BB%8B/

http://square.github.io/retrofit/

给 Android 开发者的 RxJava 详解
http://gank.io/post/560e15be2dca930e00da1083

Android 学习为ActionBar 添加返回按钮
https://github.com/Tikitoo/blog/issues/29



http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0327/2650.html
http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0106/2275.html