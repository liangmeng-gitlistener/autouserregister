package com.gtzz.autouserregister.config;

import com.gtzz.autouserregister.utils.SnowflakeFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: johnny
 * date: 2019/1/21 10:37
 */
@Configuration
public class SnowflakeBean {

    @Value("${system.workerid}")
    private int workerid;

    @Value("${system.datacenterid}")
    private int datacenterid;

    @Bean
    public SnowflakeFactory snowflakeFactory() {
        SnowflakeFactory idFactory = new SnowflakeFactory(workerid, datacenterid);
        return idFactory;
    }
}
