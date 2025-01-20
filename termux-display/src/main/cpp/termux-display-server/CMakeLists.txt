cmake_minimum_required(VERSION 3.10.1)
set(APP_GLUE_DIR ${ANDROID_NDK}/sources/android/native_app_glue)
include_directories(${APP_GLUE_DIR})
#add_library( app-glue STATIC ${APP_GLUE_DIR}/android_native_app_glue.c)

include_directories(inc)
include_directories(include)

add_library(termux-display-server
        SHARED
        renderer/server.cpp
        renderer/SocketIPCServer.cpp
        renderer/OutputClient.cpp
)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17")
target_link_libraries(termux-display-server
        log
        EGL
        GLESv3
        android
)
install(TARGETS termux-display-server LIBRARY)
install(DIRECTORY include/ TYPE INCLUDE)