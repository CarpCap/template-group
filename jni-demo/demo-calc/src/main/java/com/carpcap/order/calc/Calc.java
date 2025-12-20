package com.carpcap.order.calc;

/**
 * 计算
 *
 * @author CarpCap
 * @since 2025/12/20 15:54
 */
public class Calc {



    public static native long calcJni(String type, long a1, long a2);

    public static void main(String[] args) {

//        System.out.println(System.getProperty("java.library.path"));

        System.loadLibrary("src/main/java/com/carpcap/order/calc/Calc");
        System.out.println(calcJni("add", 3, 3));
        System.out.println(calcJni("mul", 3, 3));

    }
}
