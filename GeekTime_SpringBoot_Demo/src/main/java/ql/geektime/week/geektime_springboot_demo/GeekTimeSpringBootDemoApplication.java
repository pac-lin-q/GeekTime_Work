package ql.geektime.week.geektime_springboot_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = "ql.geektime.week.geektime_springboot_demo.HomeWork.dao")
public class GeekTimeSpringBootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(GeekTimeSpringBootDemoApplication.class, args);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("dataSource is:"+ dataSource);
    }

}
