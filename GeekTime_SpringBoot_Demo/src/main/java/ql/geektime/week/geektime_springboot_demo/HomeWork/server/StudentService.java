package ql.geektime.week.geektime_springboot_demo.HomeWork.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ql.geektime.week.geektime_springboot_demo.HomeWork.dao.StudentMapper;
import ql.geektime.week.geektime_springboot_demo.HomeWork.model.StudentInfo;

import java.util.List;

@Service
public class StudentService implements StudentMapper {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentInfo> getAllUsers() {
        return studentMapper.getAllUsers();
    }
}
