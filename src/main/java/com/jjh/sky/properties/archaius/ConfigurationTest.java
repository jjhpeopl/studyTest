package com.jjh.sky.properties.archaius;

import com.netflix.config.*;

/**
 * Created by jiajianhong on 16/9/19.
 */
public class ConfigurationTest {

    public static void main(String[] args) {

        // 设置JMX开启
        System.setProperty("archaius.dynamicPropertyFactory.registerConfigWithJMX", "true");

        PolledConfigurationSource source = new DBConfigurationSource();
        AbstractPollingScheduler scheduler = new MyScheduler();
        DynamicConfiguration configuration = new DynamicConfiguration(source, scheduler);

        ConfigurationManager.install(configuration);

        DynamicStringProperty dynamicStringProperty = DynamicPropertyFactory.getInstance().getStringProperty("name", "xiaosong");
        System.out.println(dynamicStringProperty.getValue());

        while (true) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
