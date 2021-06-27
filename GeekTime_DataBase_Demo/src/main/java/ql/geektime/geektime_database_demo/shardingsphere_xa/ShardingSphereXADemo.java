package ql.geektime.geektime_database_demo.shardingsphere_xa;

import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import ql.geektime.geektime_database_demo.util.DataSourceUtils;
import ql.geektime.geektime_database_demo.util.SnowFlakeGenerateIdWorker;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 *  ShardingSphere 的 Atomikos XA 实现一个简单的分布式事务应用 demo
 *
 */
public class ShardingSphereXADemo {

    public static void main(String[] args) throws IOException,SQLException {
        //获取shardingsphere数据库配置
        DataSource dataSource = DataSourceUtils.getShardingSphereDataSource();
        //设置事务机制位XA
        TransactionTypeHolder.set(TransactionType.XA);
        if (dataSource != null) {
            SnowFlakeGenerateIdWorker s = new SnowFlakeGenerateIdWorker(0L, 0L);
            String insertSql = "insert into ds_order (order_id,order_userid,order_proid,order_amount, order_createtime,order_endtime,order_paytime) values (?,?,'0000000000001',0.00,now(),now(),now())";
            Connection connection = null;
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement psmt = connection.prepareStatement(insertSql)) {
                for (int i = 0; i < 10; i++) {
                    Random rd1 = new Random();
                    psmt.setLong(1, s.getUid());
                    psmt.setInt(2, rd1.nextInt(20));
                    if (i == 5) {
                        throw new RuntimeException(); //当I=5的时候制造异常，检查之前的数据是否入库
                    }
                    psmt.execute();
                    connection.commit();
                }
//                connection.commit();
            } catch (Exception e){
                connection.rollback();
            }
        }
    }
}
