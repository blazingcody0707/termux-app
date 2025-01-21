how to build

git clone -b master-x11-submodule https://github.com/jiaxinchen-max/termux-app &&
cd termux-app &&
git submodule update --init --recursive &&
./gradlew syncDebugJarLibs &&
./gradlew assembleDebug

then, waiting for a while.
mkdir -p ~/.config/labwc
wget https://raw.githubusercontent.com/labwc/labwc/master/docs/environment -O ~/.config/labwc/environment
wget https://raw.githubusercontent.com/labwc/labwc/master/docs/autostart -O ~/.config/labwc/autostart
wget https://raw.githubusercontent.com/labwc/labwc/master/docs/menu.xml -O ~/.config/labwc/menu.xml
wget https://raw.githubusercontent.com/labwc/labwc/master/docs/rc.xml -O ~/.config/labwc/rc.xml

// Top-level build file where you can add configuration options common to all sub-projects/modules.

//buildscript {
//    repositories {
//        // 添加阿里云 Maven 地址
//        maven { url 'https://maven.aliyun.com/nexus/content/groups/public/' }
//        maven { url 'https://maven.aliyun.com/nexus/content/repositories/jcenter' }
//
//        google()
//        // jcenter() // 如果需要也可以保留，但阿里云镜像已包含 JCenter 的大部分内容
//    }
//    dependencies {
//        classpath 'com.android.tools.build:gradle:3.2.1'
//        // 其他应用级别的插件或工具类库请勿放在此处，应放置于各模块的 build.gradle 文件中
//    }
//}
//
//allprojects {
//    repositories {
//        // 添加阿里云 Maven 地址
//        maven { url 'https://maven.aliyun.com/nexus/content/groups/public/' }
//        maven { url 'https://maven.aliyun.com/nexus/content/repositories/jcenter' }
//
//        google()
//        // jcenter() // 同样可选保留
//    }
//}
