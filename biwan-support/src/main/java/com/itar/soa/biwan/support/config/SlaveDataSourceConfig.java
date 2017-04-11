package com.itar.soa.biwan.support.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by dengzhiyuan on 2017/4/10.
 */
@Configuration
@EnableConfigurationProperties(SlaveDruidConfig.class)
public class SlaveDataSourceConfig extends AbstractDataSourceConfig{

    private static final Logger logger= LoggerFactory.getLogger(SlaveDataSourceConfig.class);


    @Autowired
    private SlaveDruidConfig slaveDruidConfig;


    /**
     * 这个可以自己注入，也可以让spring帮助我们注入,自己可以注入多个
     */
    @Bean(name="slaveDataSource", initMethod = "init", destroyMethod = "close") //也可以为master
    public DataSource dataSource() throws Exception{
        logger.info("slave datasource正在初始化中...");
        return initDataBase(slaveDruidConfig);
    }
}
