package ql.geektime.week.geektime_springboot_demo.HomeWork.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ql.geektime.week.geektime_springboot_demo.HomeWork.model.StudentInfo;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from studentinfo")
    List<StudentInfo> getAllUsers();

}
