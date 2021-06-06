package ql.geektime.week.geektime_springboot_demo.HomeWork.dao;

import org.apache.ibatis.annotations.*;
import ql.geektime.week.geektime_springboot_demo.HomeWork.model.StudentInfo;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from studentinfo where name=#{name}")
    List<StudentInfo> getAllUsers(String name);

    @Update("update studentinfo set name='极客时间' where name=#{name}")
    int update(String name);

    @Delete("delete from studentinfo where name=#{name}")
    int deleteByName(String name);

    @Insert("insert into studentinfo (name,age,sex) values (#{name},#{age},#{sex})")
    int save(StudentInfo studentInfo);



}
