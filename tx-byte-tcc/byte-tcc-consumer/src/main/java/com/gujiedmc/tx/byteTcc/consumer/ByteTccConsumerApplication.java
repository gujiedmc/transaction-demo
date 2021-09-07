package com.gujiedmc.tx.byteTcc.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		MongoAutoConfiguration.class,  // 使用文件存储时, 不需要配置mongodb
		DataSourceTransactionManagerAutoConfiguration.class
})
public class ByteTccConsumerApplication {
	static Logger logger = LoggerFactory.getLogger(ByteTccConsumerApplication.class);

	public static void main(String[] args) throws Throwable {
		SpringApplication application = new SpringApplication(ByteTccConsumerApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
		logger.info("springboot consumer start success");
	}

}
