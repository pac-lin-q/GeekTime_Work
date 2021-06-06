package ql.geektime.week.geektime_springboot_demo.HomeWork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ql.geektime.week.geektime_springboot_demo.HomeWork.model.StudentInfo;

@Configuration
public class StudentConf {

    @Bean(name = "student")
    public StudentInfo studentInfo(){
        return new StudentInfo();
    }
}
