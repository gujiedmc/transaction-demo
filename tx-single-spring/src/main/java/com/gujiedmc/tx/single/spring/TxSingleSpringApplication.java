package com.gujiedmc.tx.single.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * spring单体事务demo
 *
 * @author gujiedmc
 * @date 2021-08-20
 */
@MapperScan("com.gujiedmc.tx.single.spring.dao.mapper")
@SpringBootApplication
public class TxSingleSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxSingleSpringApplication.class);
    }
}
