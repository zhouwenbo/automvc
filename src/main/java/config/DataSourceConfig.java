package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by bob zhou on 14-5-30.
 */
@Configuration
public class DataSourceConfig {

    @Value("${automvc.jdbc.url}")
    String url;

    @Value("${automvc.jdbc.driver}")
    String driverClassName;

    @Value("${automvc.jdbc.username}")
    String userName;

    @Value("${automvc.jdbc.password}")
    String password;

    @Bean
    public DataSource createDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setMaxActive(20);
        dataSource.setMaxIdle(10);
        dataSource.setMaxWait(5000);
        dataSource.setDefaultAutoCommit(true);
        return dataSource;
    }

    ////////////zhou

    @Bean
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }


/*
    @Bean
    @Primary
    @ConfigurationProperties(prefix="datasource.primary")
    public DataSource primaryDataSource() {
        return new FancyDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix="datasource.secondary")
    public DataSource secondaryDataSource() {
        DataSource dataSource = new DataSource();
        return dataSource;
    }*/
}
