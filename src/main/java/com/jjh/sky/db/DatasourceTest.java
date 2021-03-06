package com.jjh.sky.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.omg.IOP.ExceptionDetailMessage;
import org.omg.SendingContext.RunTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jiajianhong on 16/9/24.
 */
public class DatasourceTest {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context-database.xml");

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(100000);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(500, 500, 0, TimeUnit.SECONDS, queue);

        List<Future> result = new ArrayList<Future>();

        for (int i = 0; i < 10; i ++) {
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
            try {
                SqlSessionTemplate template = (SqlSessionTemplate) ctx.getBean("sqlSessionTemplate");
                System.out.println(template.selectOne("selectData"));
            } catch (Exception e) {
                e.printStackTrace();
            }
//            ComboPooledDataSource dataSource = (ComboPooledDataSource) ctx.getBean("datasource");
//            try {
//                Connection connection = dataSource.getConnection();
//                Thread.sleep(500);
//                connection.close();
//                System.out.println(dataSource.getNumConnections());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println("end");
        }
    }

}
