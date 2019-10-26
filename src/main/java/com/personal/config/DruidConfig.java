package com.personal.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author : YangChunLong
 * @date : Created in 2019/10/26 15:42
 * @description: 数据库连接池 配置
 * @modified By:
 * @version: :
 */
@Configuration
@EnableTransactionManagement
public class DruidConfig {
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource(@Value("${spring.mysql.driver-class-name}") String jdbcDriver,
                                 @Value("${spring.mysql.url}") String jdbcUrl,
                                 @Value("${spring.mysql.name}") String jdbcUsername,
                                 @Value("${spring.mysql.password}") String jdbcPassword,
                                 @Value("${spring.datasource.initialSize}") int initialSize,
                                 @Value("${spring.datasource.minIdle}") int minIdle,
                                 @Value("${spring.datasource.maxActive}") int maxActive,
                                 @Value("${spring.datasource.maxWait}") int maxWait,
                                 @Value("${spring.datasource.validationQuery}") String validationQuery,
                                 @Value("${spring.datasource.timeBetweenEvictionRunsMills}") int timeBetweenEvictionRunsMills,
                                 @Value("${spring.datasource.minEvictableIdleTimeMills}") int minEvictableIdleTimeMills,
                                 @Value("${spring.datasource.testOnBorrow}") boolean testOnBorrow,
                                 @Value("${spring.datasource.testOnReturn}") boolean testOnReturn,
                                 @Value("${spring.datasource.testWhileIdle}") boolean testWhileIdle,
                                 @Value("${spring.datasource.poolPreparedStatements}") boolean poolPreparedStatements,
                                 @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}") int maxPoolPreparedStatementPerConnectionSize
                                 ) {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(jdbcDriver);
        source.setUrl(jdbcUrl);
        source.setUsername(jdbcUsername);
        source.setPassword(jdbcPassword);
        source.setInitialSize(initialSize);
        source.setMinIdle(minIdle);
        source.setMaxActive(maxActive);
        source.setMaxWait(maxWait);
        source.setValidationQuery(validationQuery);
        source.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMills);
        source.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMills);
        source.setTestOnBorrow(testOnBorrow);
        source.setTestOnReturn(testOnReturn);
        source.setTestWhileIdle(testWhileIdle);
        source.setPoolPreparedStatements(poolPreparedStatements);
        source.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            source.setFilters("stat,wall");
            source.addConnectionProperty("druid.stat.mergeSql", "true");
            source.addConnectionProperty("druid.stat.slowSqlMillis", "1000");
            source.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return source;
    }


    @Bean(name = "sqlSessionFactory")
    public FactoryBean<SqlSessionFactory> sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.personal.dao.model.*");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/db/mapper/*Mapper.xml"));
//        sqlSessionFactoryBean.setConfigLocation( resolver.getResource("classpath:/config/mybatis.xml"));

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.personal.dao");
        mapperScannerConfigurer.setAnnotationClass(Repository.class);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
}
