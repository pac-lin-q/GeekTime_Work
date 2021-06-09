package ql.geektime.a_simple_starter.autoconfiguare;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

@ConfigurationProperties(prefix = "spring.geektimesimple")
@Getter
@Setter
public class SimpleDempConfiguration {
//    private Properties props = new Properties();
    private int id;
    private String name;
}
