package com.jjh.sky.heapDump;

/**
 * Created by jiajianhong on 16/10/8.
 */
public class HeapDumpTest {

    public static void main(String[] args) {
        long arr[];
        for (int i=1; i<=10000000; i*=2) {
            arr = new long[i];
        }
    }

}
