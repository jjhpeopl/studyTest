package com.jjh.sky.heapDump;

/**
 * Created by jiajianhong on 16/10/8.
 */
public class HeapDumpTest {

    public static void main(String[] args) {
        long arr[] = new long[0];
        for (int i=1; i<=10000000; i*=2) {
            arr = new long[i];

            System.out.println("size : " + i);
            Runtime runtime = Runtime.getRuntime();
            System.out.printf("maxMemory : %.2fM\n", runtime.maxMemory()*1.0/1024/1024);
            System.out.printf("totalMemory : %.2fM\n", runtime.totalMemory()*1.0/1024/1024);
            System.out.printf("freeMemory : %.2fM\n", runtime.freeMemory()*1.0/1024/1024);
        }
    }

}
