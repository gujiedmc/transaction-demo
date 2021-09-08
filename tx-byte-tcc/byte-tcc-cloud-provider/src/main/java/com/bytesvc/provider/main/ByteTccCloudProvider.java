package com.bytesvc.provider.main;

import com.bytesvc.provider.config.SpringCloudSecondaryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * 按请求粒度负载均衡(使用MongoDB存储事务日志):需引入SpringCloudConfiguration; <br />
 * 按事务粒度负载均衡(使用文件系统存储事务日志):需引入SpringCloudSecondaryConfiguration;
 */
@Import(SpringCloudSecondaryConfiguration.class)
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.bytesvc.provider")
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class }) // 使用文件存储时, 不需要配置mongodb
public class ByteTccCloudProvider {

	public static void main(String[] args) {
		SpringApplication.run(ByteTccCloudProvider.class, args);
		System.out.println("springcloud-sample-provider started!");
	}

}
