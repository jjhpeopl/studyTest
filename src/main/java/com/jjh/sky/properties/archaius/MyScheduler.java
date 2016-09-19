package com.jjh.sky.properties.archaius;

import com.netflix.config.AbstractPollingScheduler;

/**
 * Created by jiajianhong on 16/9/19.
 */
public class MyScheduler extends AbstractPollingScheduler {
    @Override
    protected void schedule(Runnable runnable) {
        System.out.println("runnable");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }
}
