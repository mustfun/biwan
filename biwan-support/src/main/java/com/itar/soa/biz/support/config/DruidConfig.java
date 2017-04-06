package com.itar.soa.biz.support.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dengzhiyuan on 2017/4/5.
 */
@ConfigurationProperties(prefix = "database.druid.druid") //这个注解只是把属性设置进去，还达不到注入要求，要么加一个@configuration，要么加个@Component
public class DruidConfig extends BaseDruidConfig{

    private Logger logger = LoggerFactory.getLogger(getClass());

}
