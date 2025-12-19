public class HelloJNI {
    static {
        // 加载生成的动态库（Windows下是 .dll, Linux/macOS 下是 .so 或 .dylib）
        System.loadLibrary("hello"); 
    }

    // 声明本地方法
    private native void sayHello();

    public static void main(String[] args) {
        new HelloJNI().sayHello(); // 调用
    }
}