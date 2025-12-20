use jni::objects::JObject;
use jni::JNIEnv;

static mut COUNTER: i32 = 0;

#[no_mangle]
pub extern "C" fn Java_HelloJNI_sayHello(_env: JNIEnv, _obj: JObject) {
    unsafe {
        COUNTER += 1;
        let current_count = COUNTER; // 先读取出来

        let s1 = String::from("hello");
        let s2 = s1;

        println!("{}, world! 当前计数: {}", s2, current_count);
    }
}
