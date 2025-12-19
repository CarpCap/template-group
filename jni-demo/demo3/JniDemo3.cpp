#include "com_carpcap_jni_JniDemo3.h"



extern "C" JNIEXPORT jint JNICALL Java_com_carpcap_jni_JniDemo3_compute
(JNIEnv* env, jclass jc , jint v1, jint v2) {
	return  v1+v2;
}