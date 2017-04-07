package com.itar.soa.biwan.support.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * Created by dengzhiyuan on 2017/4/5.
 */

//@ConditionalOnBean(DruidDataSource.class)     //只有这个bean存在的时候才会实例化

//ImportResource注解会把需要实例化的东西实例化，其实不是很需要
//但是在这里面可以配置sqlSessionFactroy等，事务等
@ImportResource("classpath:/mybatis/spring-mybatis.xml")

//会去扫描mapper下面的文件夹，已经配置在了application.properties中，所以也不是很需要
//@MapperScan(basePackages = "com.itar.soa.biwan.mapper")


@Configuration
@AutoConfigureAfter(MasterDataSourceConfig.class)
public class MybatisConfig {


    @Autowired
    private DataSource masterDataSource;

    @Autowired
    private MybatisProperties properties; //这个其实mybatis已经帮我们弄好了，直接拿出来


    /**
     * 问题： 这里的mappperLocation什么的，我都没给mybatis讲呀 ? 待会儿还是要讲的......
     * 参数给mybatis指定数据源
     * @return
     * @throws Exception
     *
     * 事实下面写了这么多真的没啥卵用，没啥卵用，没啥卵用，因为Spring会自动把 druid dataSource给mybatis，知道吗？
     * @see  org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
     */
    @Bean
    @ConditionalOnMissingBean //全文只需要一个sqlSessionFactory,所以只能用这个，意思是说当bean missing的时候就进行注入
    public SqlSessionFactory sqlSessionFactory(ResourceLoader resourceLoader) throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(masterDataSource);
        factory.setVfs(SpringBootVFS.class);

        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            factory.setConfigLocation(resourceLoader.getResource(this.properties.getConfigLocation()));
        }

        factory.setConfiguration(properties.getConfiguration());
        if (this.properties.getConfigurationProperties() != null) {
            factory.setConfigurationProperties(this.properties.getConfigurationProperties());
        }
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }

        return factory.getObject();
    }
}
