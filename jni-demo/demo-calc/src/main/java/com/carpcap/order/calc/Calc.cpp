#include "com_carpcap_order_calc_Calc.h"
#include <iostream> // 引入输入输出流
#include <string.h>


extern "C" {
    JNIEXPORT jlong JNICALL Java_com_carpcap_order_calc_Calc_calcJni
      (JNIEnv *env, jclass clazz, jstring s, jlong a, jlong b) {
        
        jlong result = 0;

        // 1. 转换字符串
        const char *c_str = env->GetStringUTFChars(s, nullptr);
        
        if (c_str != nullptr) {
            // 2. 使用 strcmp 进行比较 (C 风格)
            // 如果字符串相等，strcmp 返回 0
            if (strcmp(c_str, "add") == 0) {
                result = a + b;
            } else if (strcmp(c_str, "mul") == 0) {
                result = a * b;
            } else {
                result = -1; // 未知操作
            }

            // 3. 必须释放内存
            env->ReleaseStringUTFChars(s, c_str);
        }

        return result;
    }
}