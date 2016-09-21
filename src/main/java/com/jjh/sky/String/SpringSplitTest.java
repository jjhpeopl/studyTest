package com.jjh.sky.String;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by jiajianhong on 16/8/24.
 */
public class SpringSplitTest {


    public static void main (String[] args) {
        String test1 = "1,2,3,";
        System.out.println(test1.split(",").length);
        System.out.println(StringUtils.split(test1, ",").length);
        System.out.println(StringUtils.splitPreserveAllTokens(test1, ",").length);

        System.out.println(Splitter.onPattern("12").omitEmptyStrings().split(test1).toString());

        // 把字符串解析成map
        String str = "a=1;b=2";
        Map<String, String> resultMap = Splitter.onPattern(";").withKeyValueSeparator("=").split(str);
        System.out.println(resultMap.toString());

        // 把map转成字符串
        String resultStr = Joiner.on(";").withKeyValueSeparator("=").join(resultMap);
        System.out.println(resultStr);

    }

}
