package com.jjh.sky.thrift.asyncServer;

import com.jjh.sky.thrift.demo.HelloWorldService;
import com.jjh.sky.thrift.demo.impl.HelloWorldImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * Created by jiajianhong on 16/9/8.
 * 异步方式
 */
public class HelloServerDemo {

    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("asyncServer start ...");

            // 生成处理类
            TProcessor processor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());

            // 打开端口
            TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(SERVER_PORT);

            // 封装参数
            TNonblockingServer.Args args = new TNonblockingServer.Args(serverSocket);
            args.processor(processor);
            args.protocolFactory(new TCompactProtocol.Factory());
            args.transportFactory(new TFramedTransport.Factory());

            // 使用非阻塞式IO,服务端和客户端需要指定TFramedTransport数据传输方式
            TServer server = new TNonblockingServer(args);
            server.serve();

        } catch (Exception e) {
            System.out.println("asyncServer start error!!!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HelloServerDemo helloServerDemo = new HelloServerDemo();
        helloServerDemo.startServer();
    }

}
