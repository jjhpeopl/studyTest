package com.jjh.sky.properties.archaius;

import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;

import java.util.HashMap;

/**
 * Created by jiajianhong on 16/9/19.
 */
public class DBConfigurationSource implements PolledConfigurationSource {

    public PollResult poll(boolean b, Object o) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "jjh");
        PollResult pollResult = PollResult.createFull(map);
        return pollResult;
    }
}
