package com.gujiedmc.tx.byteTcc.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class,HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
// 使用文件存储时, 不需要配置mongodb
@EnableJpaRepositories(basePackages = "com.gujiedmc.tx.byteTcc.provider.springdata", entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "jtaTransactionManager")
@EntityScan(basePackages = {"com.gujiedmc.tx.byteTcc.provider.model.*"})
public class ByteTccProviderApplication {
    static Logger logger = LoggerFactory.getLogger(ByteTccProviderApplication.class);

    public static void main(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(ByteTccProviderApplication.class);
        application.run(args);
        logger.info("springboot provider start success");
    }

}
