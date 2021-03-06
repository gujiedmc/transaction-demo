package com.bytesvc.consumer.main;

import com.bytesvc.consumer.config.SpringCloudSecondaryConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * 按请求粒度负载均衡(使用MongoDB存储事务日志):需引入SpringCloudConfiguration; <br />
 * 按事务粒度负载均衡(使用文件系统存储事务日志):需引入SpringCloudSecondaryConfiguration;
 */
@Import(SpringCloudSecondaryConfiguration.class)
@MapperScan("com.bytesvc.consumer.dao")
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients("com.bytesvc.feign")
@SpringBootApplication(scanBasePackages = "com.bytesvc.consumer")
@EnableCircuitBreaker
@EnableHystrix
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})  // 使用文件存储时, 不需要配置mongodb
public class ByteTccCloudConsumer implements BeanFactoryAware {
    private static BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(ByteTccCloudConsumer.class, args);
        System.out.println("springcloud-sample-consumer started!");
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory = factory;
    }

}
