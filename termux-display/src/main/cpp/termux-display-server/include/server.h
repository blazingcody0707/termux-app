#include <unistd.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <pthread.h>
#include <android/hardware_buffer.h>
#include <jni.h>

void setWindow(JNIEnv *env, jobject sf);

void DisplayServerInit();

void ServerStart(void *);