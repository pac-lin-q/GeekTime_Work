package ql.geektime.a_simple_starter.autoconfiguare;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ql.geektime.a_simple_starter.aop.ISchool;

import javax.annotation.Resource;

@Getter
@Setter
public class School implements ISchool {

    SimpleDempConfiguration simpleDempConfiguration;
    // Resource
    @Autowired(required = true) //primary
            Klass class1;


    @Override
    public String ding(){
//        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + simpleDempConfiguration.ge);
        return simpleDempConfiguration.getId()+":"+simpleDempConfiguration.getName();
    }
}
