package com.caiquan.jni;

/**
 * @author  CarpCap
 */
public class JniDemo {
    // 定义 native 方法
    public static native String getLine(String prompt);

    static {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("win") || osName.startsWith("Win")) {
            System.load("C:\\projects\\github\\Template-group\\jni-demo\\src\\main\\java\\com\\caiquan\\jni\\JniDemo.dll");
//            System.loadLibrary("src/main/java/com/caiquan/jni/JniDemo");
        } else {
            //这里需要提前将 JniDemo.so 放入linux目录/usr/lib 下 并且执行命令sudo ldconfig
//            System.loadLibrary("JniDemo");
            System.load("/usr/lib/libJniDemo.so");
        }
    }

    public static void main(String[] args) {
        // 加载库文件（不用带后缀名）
        // 调用方法
        String line = getLine("This is Java message!!!");
        System.out.println(line);
    }

}
