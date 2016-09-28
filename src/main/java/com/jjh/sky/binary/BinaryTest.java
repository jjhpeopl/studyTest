package com.jjh.sky.binary;

/**
 * Created by jiajianhong on 16/9/1.
 */
public class BinaryTest {

    public static void main(String[] args) {
        int i = 9;     // 二进制1001
        int j = 14;     // 二进制1110

        i = i ^ j;
        System.out.println("1001 ^ 1110 = 0111");
        j = i ^ j;
        System.out.println("0111 ^ 1110 = 1001");
        i = i ^ j;
        System.out.println("0111 ^ 1001 = 1110");

        System.out.println("i=" + i + ",j=" + j);

        int k = -2;
        System.out.println(k << 1);
        System.out.println(k >> 31);
        System.out.println((k << 1) ^ (k >> 31));

    }

}
