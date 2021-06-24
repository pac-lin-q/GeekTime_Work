package ql.geektime.geektime_database_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.activation.DataSource;

@SpringBootApplication
public class GeektimeDatabaseDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =SpringApplication.run(GeektimeDatabaseDemoApplication.class, args);
//        System.out.println(applicationContext.getBean());

    }

}
