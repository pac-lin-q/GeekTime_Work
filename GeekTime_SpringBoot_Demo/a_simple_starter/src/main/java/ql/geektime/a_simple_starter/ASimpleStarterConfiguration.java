package ql.geektime.a_simple_starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ql.geektime.a_simple_starter.autoconfiguare.School;
import ql.geektime.a_simple_starter.autoconfiguare.SimpleDempConfiguration;

@Configuration
@EnableConfigurationProperties(SimpleDempConfiguration.class)
public class ASimpleStarterConfiguration {

    @Autowired
    SimpleDempConfiguration simpleDempConfiguration;

    @Bean
    public String school(){
        School sc = new School();
        return sc.ding();
    }


}
