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
    public List<StudentInfo> getAllUsers(String name) {
        return studentMapper.getAllUsers(name);
    }

    @Override
    public int update(String name) {
        return studentMapper.update(name);
    }

    @Override
    public int deleteByName(String name) {
        return studentMapper.deleteByName(name);
    }

    @Override
    public int save(StudentInfo studentInfo) {
        return studentMapper.save(studentInfo);
    }
}
