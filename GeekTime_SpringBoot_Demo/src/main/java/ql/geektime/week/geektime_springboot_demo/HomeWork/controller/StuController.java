package ql.geektime.week.geektime_springboot_demo.HomeWork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ql.geektime.week.geektime_springboot_demo.HomeWork.server.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StuController {
    @Autowired
    StudentService testQuerServe;

    @GetMapping("getResult")
    public List getResult(){
        List list = testQuerServe.getAllUsers();
        return  list;
//        System.out.println("getResult is:" + list);
    }
}
