package com.jjh.sky.regexp;

/**
 * Created by jiajianhong on 16/9/14.
 */
public class RegexpTest {

    public static void main(String[] args) {
        // 不包含内容进行拆分
        String str = "127.0.0.1:8080";
        String[] result = str.split("[^0-9a-zA-Z_\\-\\.:]+");
        for (String r : result) {
            System.out.println(r);
        }
    }

}
