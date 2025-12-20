package com.carpcap.order.calc;

/**
 * 计算
 *
 * @author CarpCap
 * @since 2025/12/20 15:54
 */
public class Calc {


    public static native long calcJni(String type, long a1, long a2);


    static {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("win") || osName.startsWith("Win")) {
            System.loadLibrary("src/main/resources/calc");
        } else {
            // 这里需要提前将 JniDemo.so 放入linux目录/usr/lib 下 并且执行命令sudo ldconfig
            System.load("/usr/lib/calc.so");
        }

    }

    public static void main(String[] args) {

        System.out.println(calcJni("add", 5, 5));
        System.out.println(calcJni("mul", 5, 5));

    }
}
