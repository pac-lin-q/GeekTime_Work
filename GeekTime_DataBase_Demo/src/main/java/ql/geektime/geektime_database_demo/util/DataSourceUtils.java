package ql.geektime.geektime_database_demo.util;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DataSourceUtils {

    public static DataSource getShardingSphereDataSource(){
        DataSource dataSource = null;
        try {
            dataSource= YamlShardingSphereDataSourceFactory.createDataSource(new File("./src/main/resources/shardingJDBC.yml"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
