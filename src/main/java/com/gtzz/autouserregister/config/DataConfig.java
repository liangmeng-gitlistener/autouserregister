package com.gtzz.autouserregister.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 使用对象配置
 */
@Component          //是多例模式
@ConfigurationProperties(prefix = "data")
@Data
public class DataConfig {
    /**
     * 职位id
     */
    private Long dutiesId;
    /**
     * 租户id
     */
    private Long tenantId;
}
