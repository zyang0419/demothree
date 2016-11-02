package com.baichou.springboot.datasource;/**
 * Created by root on 16-11-2.
 */

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源创建
 *
 * @author zyang0419
 * @create 2016-11-02 下午5:04
 **/
@Configuration
public class GlobalDataConfiguration {
    @Bean(name="primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="datasource.primary")
    public DataSource primaryDataSource() {
        System.out.println("-------------------- primaryDataSource init ---------------------");
        return DataSourceBuilder.create().build();
    }

    @Bean(name="secondaryDataSource")
    @ConfigurationProperties(prefix="datasource.secondary")
    public DataSource secondaryDataSource() {
        System.out.println("-------------------- secondaryDataSource init ---------------------");
        return DataSourceBuilder.create().build();
    }

    @Bean(name="defaultDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource defaultDataSource() {
        System.out.println("-------------------- primaryDataSource init ---------------------");
        return DataSourceBuilder.create().build();
    }
}