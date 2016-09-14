package com.jjh.sky.thrift.mtThrift_serverIpPorts;

import com.sankuai.meituan.waimai.thrift.bizdata.enums.WmBizdataManagerWarnTypeEnum;
import com.sankuai.meituan.waimai.thrift.bizdata.service.WmBizdataManagerThriftService;
import com.sankuai.meituan.waimai.thrift.bizdata.vo.InDate;
import org.apache.thrift.TException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiajianhong on 16/9/14.
 */
public class ServerIpPortsTest {

    public static ClassPathXmlApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("classpath*:context.xml");
        WmBizdataManagerThriftService.Iface wmBizdataManagerThriftService = (WmBizdataManagerThriftService.Iface) ctx.getBean("WmBizdataManagerThriftService");
        InDate inDate = new InDate();
        inDate.setBeginDate("2016-09-09 00:00:00");
        inDate.setEndDate("2016-09-10 00:00:00");
        try {
            wmBizdataManagerThriftService.getWarnLog(inDate, WmBizdataManagerWarnTypeEnum.ALL);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

}
