package ql.geektime.geektime_database_demo.config;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ql.geektime.geektime_database_demo.util.DataSourceUtils;
import ql.geektime.geektime_database_demo.util.SnowFlakeGenerateIdWorker;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * 设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。
 * YML配置文件：shardingJDBC.yml
 */
@Configuration
public class ShardingJDBC {

    @Bean(name = "shardingDataSource")
    public void init(){
            DataSource dataSource = DataSourceUtils.getShardingSphereDataSource();
//            addBactch("",dataSource);
//            query(dataSource,857632453735481345L);
//            upData(dataSource);
//            delData(dataSource);
    }

    public static void insetData(DataSource dataSource,int num){
        Long l = System.currentTimeMillis();
        System.out.println(l);
        SnowFlakeGenerateIdWorker s = new SnowFlakeGenerateIdWorker(0L,0L);
        String sql = "insert into ds_order (order_id,order_userid,order_proid,order_amount, order_createtime,order_endtime,order_paytime) values (?,?,'0000000000001',0.00,'2021-06-22 15:53:51','2021-06-22 15:53:51','2021-06-22 15:53:51')";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement psmt = conn.prepareStatement(sql);
            Long lo = 0L;
            for (int i = 0; i <num ; i++) {
                Random rd1 = new Random();
                lo=s.getUid();
                System.out.println("lo is:" + lo);
                psmt.setLong(1, l);
                psmt.setInt(2,rd1.nextInt(1000));
                psmt.addBatch();
                if (i%20000 ==0){
                    psmt.executeBatch();
                    psmt.clearBatch();
                }
            }
            psmt.executeBatch();
            conn.commit();
            query(dataSource,1624517988212L);
            System.out.println("TIME IS:"+ (System.currentTimeMillis()-l)/1000);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void query(DataSource dataSource,Long orderid){
        System.out.println(orderid+"=="+(orderid/16));
        String sql = "select * from ds_order where order_userid=588";
        System.out.println(dataSource);
        try {
            List l = new ArrayList<>();
            Connection conn = dataSource.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                ResultSetMetaData md = rs.getMetaData();
                int n = rs.getMetaData().getColumnCount();
                Map m = new HashMap<>();
                for (int i = 1; i <=n ; i++) {
                    m.put(md.getColumnName(i),rs.getObject(i));
                }
                l.add(m);
            }
            System.out.println(l.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delData(DataSource dataSource){
        String sql = "delete from ds_order where order_id =857410283482644483";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upData(DataSource dataSource){
        String sql = "update ds_order set order_proid='xsfaaa' where order_id =857397376585826304";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBactch(String batchFlag,DataSource source){
        if ("0".equals(batchFlag)){
            for (int i = 0; i <2 ; i++) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        insetData(source,250000);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.setName("insert-thread-"+i);
                System.out.println(thread.getName());
                thread.start();
            }
        }else {
            System.out.println("不是多线程并发插入数据");
            insetData(source,1);
        }
    }
}
