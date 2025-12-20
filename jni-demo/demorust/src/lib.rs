use jni::objects::JObject;
use jni::JNIEnv;

/// 对应 Java：
/// private native void sayHello();
#[no_mangle]
pub extern "C" fn Java_HelloJNI_sayHello(_env: JNIEnv, _obj: JObject) {
    // 最简单、最稳的实现
    let s1 = String::from("hello");
    let s2 = s1;

    println!("{}, world!", s2);

}
