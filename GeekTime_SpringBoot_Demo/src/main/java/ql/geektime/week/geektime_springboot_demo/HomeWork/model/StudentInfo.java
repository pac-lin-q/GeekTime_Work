package ql.geektime.week.geektime_springboot_demo.HomeWork.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentInfo {

    private String name;
    private String age;
    private String sex;
    private String cardid;
    private String kcid;
}
