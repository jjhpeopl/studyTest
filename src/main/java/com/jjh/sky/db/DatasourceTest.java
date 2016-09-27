package com.jjh.sky.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.omg.SendingContext.RunTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiajianhong on 16/9/24.
 */
public class DatasourceTest {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context-database.xml");

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100000);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30, 30, 0, TimeUnit.SECONDS, queue);

        for (int i = 0; i < 2000; i ++) {
            Task task1 = new Task(ctx);
            Thread t = new Thread(task1);
            threadPoolExecutor.submit(t);
        }

    }

    static class Task implements Runnable {

        private ClassPathXmlApplicationContext ctx;

        public Task(ClassPathXmlApplicationContext ctx) {
            this.ctx = ctx;
        }

        public void run() {
            SqlSessionTemplate template = (SqlSessionTemplate) ctx.getBean("sqlSessionTemplate");
            System.out.println(template.selectOne("selectData"));
            ComboPooledDataSource dataSource = (ComboPooledDataSource) ctx.getBean("datasource");
            try {
                Connection connection = dataSource.getConnection();
                Thread.sleep(500);
                connection.close();
                System.out.println(dataSource.getNumConnections());
            } catch (Exception e) {
                e.printStackTrace();
            }

//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println("end");
        }
    }

}
