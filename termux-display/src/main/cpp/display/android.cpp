
#include "client.h"
#include "server.h"
#include "InputServer.h"
#include "LogUtil.h"

void inputCallback(InputEvent ev) {
    LOG_I("%d", ev.type);
}
void initClient() {
    DisplayClientInit(800, 600, 4);
    InputInit(inputCallback);
    pthread_t t;
    pthread_create(&t, NULL, reinterpret_cast<void *(*)(void *)>(DisplayClientStart), nullptr);
}

extern "C" JNIEXPORT void JNICALL
Java_com_termux_display_RenderSurface_windowChanged(JNIEnv *env, jobject thiz, jobject surface,
                                                    jstring jname) {
    jobject sf = surface ? env->NewGlobalRef(surface) : NULL;
    setWindow(env, sf);
    DisplayServerInit();
}
extern "C" JNIEXPORT void JNICALL
Java_com_termux_display_RenderSurface_startClient(JNIEnv *env, jobject thiz) {
    initClient();
}
