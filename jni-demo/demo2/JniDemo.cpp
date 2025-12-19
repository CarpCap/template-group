#include "com_carpcap_jni_JniDemo.h"



extern "C" JNIEXPORT jstring JNICALL Java_com_carpcap_jni_JniDemo_getLine
(JNIEnv* env, jclass jc , jstring str) {
	// 1. 获取 C 字符串
    const char* c_str = env->GetStringUTFChars(str, NULL);
    
    char buf[1024];
    // 2. 拼接字符串到 buf 中
    sprintf(buf, "%s from jni", c_str);
    
    // 3. 释放 c_str 
    env->ReleaseStringUTFChars(str, c_str);
    
    // 4. 直接返回 buf（NewStringUTF 会把 buf 的内容拷贝成新的 Java String）
    return env->NewStringUTF(buf);
}