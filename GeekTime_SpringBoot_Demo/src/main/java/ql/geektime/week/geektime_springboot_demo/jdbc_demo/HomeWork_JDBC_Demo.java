package ql.geektime.week.geektime_springboot_demo.jdbc_demo;


import java.sql.*;
import java.util.concurrent.locks.Condition;

public class HomeWork_JDBC_Demo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ql_demo";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "spdb1234";

    public static void main(String[] args) {
        new HomeWork_JDBC_Demo().queryData("select * from studentinfo");
        new HomeWork_JDBC_Demo().addData("insert into studentinfo (name,age,sex,cardid,kcid) values (?,?,?,?,?)");
    }

    public void addData(String sql){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println(" 实例化PreparedStatement对象...");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"极客1");
            pstmt.setString(2,"18");
            pstmt.setString(3,"0");
            pstmt.setString(4,"6217964585467123");
            pstmt.setString(5,"");
            pstmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                conn.close();
                System.out.println("断开数据库...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void queryData(String sql){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println(" 实例化PreparedStatement对象...");
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                conn.close();
                System.out.println("断开数据库...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
