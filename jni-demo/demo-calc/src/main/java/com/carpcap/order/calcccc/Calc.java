package com.carpcap.order.calcccc;

/**
 * 计算
 *
 * @author CarpCap
 * @since 2025/12/20 15:54
 */
public class Calc {

    /**
     * 计算金额
     *
     * @return 金额
     * @author CarpCap
     * @since 2025/12/20 15:55
     */
    public static long calc(String type, long a1, long a2) {
        switch (type) {
            case "add":
                return a1 + a2;
            case "mul":
                return a1 * a2;
            default:
                return -1;
        }
    }



    public static void main(String[] args) {
        System.out.println(calc("add", 3, 3));
        System.out.println(calc("mul", 3, 3));

    }
}
