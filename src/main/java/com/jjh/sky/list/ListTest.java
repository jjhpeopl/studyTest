package com.jjh.sky.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiajianhong on 16/10/13.
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");
        stringList.add("8");

        int limit = 3;
        for (int index = 0; index < stringList.size();) {
            List<String> partList = stringList.subList(index,
                    (index + limit) > stringList.size() ? stringList.size() : (index + limit));
            index = index + limit;

            System.out.println(partList);
        }


    }

}
