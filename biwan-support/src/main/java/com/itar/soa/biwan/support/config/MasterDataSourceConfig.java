package com.itar.soa.biwan.support.config;

import ch.qos.logback.classic.Logger;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Created by dengzhiyuan on 2017/4/6.
 */
@Configuration
@EnableConfigurationProperties(DruidConfig.class)  //这个就相当于把DruidConfig也注入了，那边没有注入
public class MasterDataSourceConfig {

    @Autowired
    private DruidConfig druidConfig;

    @Autowired
    private Slf4jLogFilter slf4jLogFilter;


    /**
     * 这个可以自己注入，也可以让spring帮助我们注入,自己可以注入多个
     */
    @Bean(name="masterDataSource", initMethod = "init", destroyMethod = "close") //也可以为master
    @Primary  //Spring优先选择被该注解所标记的数据源
    public DataSource dataSource() throws Exception{
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(druidConfig.getUrl());
        datasource.setUsername(druidConfig.getUsername());
        datasource.setPassword(druidConfig.getPassword());
        datasource.setDriverClassName(druidConfig.getDriverClassName());
        datasource.setInitialSize(druidConfig.getInitialSize());
        datasource.setMinIdle(druidConfig.getMinIdle());
        datasource.setMaxActive(druidConfig.getMaxActive());
        datasource.setMaxWait(druidConfig.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(druidConfig.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(druidConfig.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(druidConfig.getValidationQuery());
        /*
        datasource.setTestWhileIdle(druidConfig.get);
        datasource.setTestOnBorrow(druidConfig.gette);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(druidConfig.getpo);
        datasource.setMaxOpenPreparedStatements(druidConfig.);
        */
        //设置druid监控
        datasource.setFilters(druidConfig.getFilters());
        //设置druid日志
        datasource.setProxyFilters(Arrays.asList(slf4jLogFilter));

        datasource.setMaxPoolPreparedStatementPerConnectionSize(druidConfig.getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setConnectionProperties(druidConfig.getConnectionProperties());
        datasource.setConnectionProperties(druidConfig.getConnectionProperties());
        return datasource;
    }
}
