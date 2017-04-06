package com.itar.soa.biwan.support.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by dengzhiyuan on 2017/4/5.
 */
@AutoConfigureAfter(DruidConfig.class)
//这个注解会把需要实例化的东西实例化，其实不是很需要
@ImportResource("classpath:/mybatis/spring-mybatis.xml")
@MapperScan(basePackages = "com.itar.soa.biwan.mapper")
public class MybatisConfig {

}
