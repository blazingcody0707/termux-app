#pragma once

#include <cstdint>
#include <string>
#include <vector>
#include <android/asset_manager.h>
#include <EGL/egl.h>

#define EGL_EGLEXT_PROTOTYPES
#define GL_GLEXT_PROTOTYPES

#include <EGL/eglext.h>
#include <GLES2/gl2.h>
#include <GLES2/gl2ext.h>
#include <GLES2/gl2platform.h>
#include <android/hardware_buffer.h>
#include <jni.h>
#include <android/asset_manager.h>
#include <android/asset_manager_jni.h>

class SocketIPCServer {
public:
    static SocketIPCServer *GetInstance();

    void Init(AHardwareBuffer *hwBuffer, JNIEnv *e, jobject sf);

    void Destroy();

    void Draw();

    AAssetManager *m_NativeAssetManager;
    struct android_app *m_GlobalApp;
private:
    SocketIPCServer() = default;

    uint8_t *ReaderImage(const char *fileName, size_t *outFileLength);

    void RenderSetWindow(JNIEnv *env, jobject new_surface);

    int InitEGLEnv();

    void DestroyEGLEnv();

    void CreateProgram();

    int ReadShader(const char *fileName, std::vector<char> &source) const;

    static SocketIPCServer s_Renderer;

    EGLDisplay m_EglDisplay = EGL_NO_DISPLAY;
    EGLSurface m_EglSurface = EGL_NO_SURFACE;
    EGLContext m_EglContext = EGL_NO_CONTEXT;
    EGLConfig m_EglConfig;

    GLint m_VertexShader;
    GLint m_FragShader;
    GLuint m_Program;
    uint32_t m_ImgWidth = 1024;
    uint32_t m_ImgHeight = 1024;

    GLuint m_InputTexture;
    GLuint m_Framebuffer = 0;
    EGLImageKHR m_NativeBufferImage;
    AHardwareBuffer *buffer;

    size_t len0, len1, len2;
    uint8_t *imageData0, *imageData1, *imageData2;
    int cur = 0;

    uint8_t *chs;
};