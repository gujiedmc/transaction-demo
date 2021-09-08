package com.bytesvc.consumer.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.netflix.loadbalancer.IRule;
import org.bytesoft.bytetcc.supports.springcloud.loadbalancer.CompensableLoadBalancerRuleImpl;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * @author gujiedmc
 * @date 2021-09-07
 */
@Configuration
@AutoConfigureBefore({
        DruidDataSourceAutoConfigure.class,
        DataSourceAutoConfiguration.class
})
public class DruidConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource() {
        return new DruidDataSource();
    }

    @Bean
    public IRule loadbalancerRule(){
        return new CompensableLoadBalancerRuleImpl();
    }
}
