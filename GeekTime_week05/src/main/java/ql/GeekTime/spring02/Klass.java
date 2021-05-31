package ql.GeekTime.spring02;

import lombok.Data;
import ql.GeekTime.spring01.Student;

import java.util.List;

@Data
public class Klass {
    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }
}
