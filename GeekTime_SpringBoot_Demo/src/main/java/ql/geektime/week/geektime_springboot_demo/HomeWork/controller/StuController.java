package ql.geektime.week.geektime_springboot_demo.HomeWork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ql.geektime.week.geektime_springboot_demo.HomeWork.model.StudentInfo;
import ql.geektime.week.geektime_springboot_demo.HomeWork.server.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StuController {
    @Autowired
    StudentService testQuerServe;

    @Autowired
    StudentInfo studentInfo;

    @GetMapping("getResult/{name}")
    public List getResult(@PathVariable String name){
        List list = testQuerServe.getAllUsers(name);
        return  list;
    }

    @GetMapping("forUpdate/{name}")
    public int forUpdate(@PathVariable String name){
        return testQuerServe.update(name);
    }

    @GetMapping("addStu")
    public int addStu(){
        studentInfo.setName("测试");
        studentInfo.setAge("18");
        studentInfo.setSex("0");
        return testQuerServe.save(studentInfo);
    }

    @GetMapping("remove/{name}")
    public int remove(@PathVariable String name){
        return testQuerServe.deleteByName(name);
    }
}
