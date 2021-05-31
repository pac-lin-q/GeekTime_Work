package ql.GeekTime.springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ql.GeekTime.spring01.Student;

public class JmsSender {
    public static void main( String[] args )
    {
        Student student2 = new Student(204, "KK0204", null, null);

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springjms-sender.xml");

        SendService sendService = (SendService)context.getBean("sendService");

        sendService.send(student2);

        System.out.println("send successfully, please visit http://localhost:8161/admin to see it");
    }
}
