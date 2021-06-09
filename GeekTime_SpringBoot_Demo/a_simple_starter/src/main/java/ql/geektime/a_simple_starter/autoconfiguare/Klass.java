package ql.geektime.a_simple_starter.autoconfiguare;

import lombok.Data;

import java.util.List;

@Data
public class Klass {
    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }
}
