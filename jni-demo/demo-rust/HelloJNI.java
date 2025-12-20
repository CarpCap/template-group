public class HelloJNI {
    static {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("win") || osName.startsWith("Win")) {
            System.loadLibrary("hello");
        } else {
            // 这里需要提前将 JniDemo.so 放入linux目录/usr/lib 下 并且执行命令sudo ldconfig
            System.load("/usr/lib/hello.so");
        }

    }

    // 声明本地方法
    private native void sayHello();

    public static void main(String[] args) {
        new HelloJNI().sayHello(); // 调用
        new HelloJNI().sayHello(); // 调用
        new HelloJNI().sayHello(); // 调用
    }
}