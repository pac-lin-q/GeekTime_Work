package ql.GeekTime.spring02;

import org.springframework.beans.factory.annotation.Autowired;
import ql.GeekTime.AOP.ISchool;
import ql.GeekTime.spring01.Student;

import javax.annotation.Resource;

public class School implements ISchool {

    // Resource
    @Autowired(required = true) //primary
            Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding(){

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);

    }
}
