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
