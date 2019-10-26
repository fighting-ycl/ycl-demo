package com.personal.SampleApplication;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.FactoryBean;
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
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidConfig {
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource(@Value("${}") String jdbcDriver,
                                 @Value("${mysql.url.social}") String jdbcUrl,
                                 @Value("${mysql.username}") String jdbcUsername,
                                 @Value("${mysql.password}") String jdbcPassword) {
        DruidConfigPropertiesVo druidConfigPropertiesVo = new DruidConfigPropertiesVo();
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(jdbcDriver);
        source.setUrl(jdbcUrl);
        source.setUsername(jdbcUsername);
        source.setPassword(jdbcPassword);
        source.setInitialSize(druidConfigPropertiesVo.getInitalSize());
        source.setMinIdle(druidConfigPropertiesVo.getMinIdle());
        source.setMaxActive(druidConfigPropertiesVo.getMaxActive());
        source.setMaxWait(druidConfigPropertiesVo.getMaxWait());
        source.setValidationQuery(druidConfigPropertiesVo.getValidationQuery());
        source.setTimeBetweenEvictionRunsMillis(druidConfigPropertiesVo.getTimeBetweenEvictionRunsMills());
        source.setMinEvictableIdleTimeMillis(druidConfigPropertiesVo.getMinEvictableTimeMills());
        source.setTestOnBorrow(druidConfigPropertiesVo.isTestOnBorrow());
        source.setTestOnReturn(druidConfigPropertiesVo.isTestOnReturn());
        source.setTestWhileIdle(druidConfigPropertiesVo.isTestWhileIdle());
        source.setPoolPreparedStatements(druidConfigPropertiesVo.isPoolPreparedStatements());
        source.setMaxPoolPreparedStatementPerConnectionSize(druidConfigPropertiesVo.getMaxPoolPreparedStatementPerConnectionSize());
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
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("config/mybatis.xml"));

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

    @ConfigurationProperties(prefix = "spring.dataSource")
    public class DruidConfigPropertiesVo {
        private int initalSize;
        private int minIdle;
        private int maxActive;
        private int maxWait;
        private String validationQuery;
        private int timeBetweenEvictionRunsMills;
        private int minEvictableTimeMills;
        private boolean testOnBorrow;
        private boolean testOnReturn;
        private boolean testWhileIdle;
        private boolean poolPreparedStatements;
        private int maxPoolPreparedStatementPerConnectionSize;

        public int getInitalSize() {
            return initalSize;
        }

        public DruidConfigPropertiesVo setInitalSize(int initalSize) {
            this.initalSize = initalSize;
            return this;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public DruidConfigPropertiesVo setMinIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public int getMaxActive() {
            return maxActive;
        }

        public DruidConfigPropertiesVo setMaxActive(int maxActive) {
            this.maxActive = maxActive;
            return this;
        }

        public int getMaxWait() {
            return maxWait;
        }

        public DruidConfigPropertiesVo setMaxWait(int maxWait) {
            this.maxWait = maxWait;
            return this;
        }

        public String getValidationQuery() {
            return validationQuery;
        }

        public DruidConfigPropertiesVo setValidationQuery(String validationQuery) {
            this.validationQuery = validationQuery;
            return this;
        }

        public int getTimeBetweenEvictionRunsMills() {
            return timeBetweenEvictionRunsMills;
        }

        public DruidConfigPropertiesVo setTimeBetweenEvictionRunsMills(int timeBetweenEvictionRunsMills) {
            this.timeBetweenEvictionRunsMills = timeBetweenEvictionRunsMills;
            return this;
        }

        public int getMinEvictableTimeMills() {
            return minEvictableTimeMills;
        }

        public DruidConfigPropertiesVo setMinEvictableTimeMills(int minEvictableTimeMills) {
            this.minEvictableTimeMills = minEvictableTimeMills;
            return this;
        }

        public boolean isTestOnBorrow() {
            return testOnBorrow;
        }

        public DruidConfigPropertiesVo setTestOnBorrow(boolean testOnBorrow) {
            this.testOnBorrow = testOnBorrow;
            return this;
        }

        public boolean isTestOnReturn() {
            return testOnReturn;
        }

        public DruidConfigPropertiesVo setTestOnReturn(boolean testOnReturn) {
            this.testOnReturn = testOnReturn;
            return this;
        }

        public boolean isTestWhileIdle() {
            return testWhileIdle;
        }

        public DruidConfigPropertiesVo setTestWhileIdle(boolean testWhileIdle) {
            this.testWhileIdle = testWhileIdle;
            return this;
        }

        public boolean isPoolPreparedStatements() {
            return poolPreparedStatements;
        }

        public DruidConfigPropertiesVo setPoolPreparedStatements(boolean poolPreparedStatements) {
            this.poolPreparedStatements = poolPreparedStatements;
            return this;
        }

        public int getMaxPoolPreparedStatementPerConnectionSize() {
            return maxPoolPreparedStatementPerConnectionSize;
        }

        public DruidConfigPropertiesVo setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
            this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
            return this;
        }
    }
}
